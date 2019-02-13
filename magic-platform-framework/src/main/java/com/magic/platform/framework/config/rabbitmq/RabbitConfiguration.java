package com.magic.platform.framework.config.rabbitmq;

import com.magic.platform.support.properties.RabbitProperties;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-17 15:15
 * @Modified By:
 */
@Configuration
@EnableConfigurationProperties(RabbitProperties.class)
@ConditionalOnExpression("${framework.config.rabbit.enable: false}")
public class RabbitConfiguration {

  public static final String CONNECTION_FACTORY = "defaultConnectionFactory";
  public static final String RABBIT_LISTENER_CONTAINER_FACTORY = "rabbitListenerContainerFactory";
  public static final String RABBIT_TEMPLATE = "rabbitTemplate";

  @Autowired
  private RabbitProperties rabbitProperties;

  /**
   * 声明连接工厂
   * https://docs.spring.io/spring-amqp/docs/2.1.0.RELEASE/reference/html/_reference.html#_rabbitconnectionfactorybean_and_configuring_ssl
   * @return
   */
  @Bean(name = CONNECTION_FACTORY)
  public ConnectionFactory defaultConnectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setAddresses(rabbitProperties.getAddresses());
    connectionFactory.setUsername(rabbitProperties.getUsername());
    connectionFactory.setPassword(rabbitProperties.getPassword());
    connectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());
    connectionFactory.setPublisherConfirms(true);
    // 保证消息的事务性处理rabbitmq默认的处理方式为auto
    // ack，这意味着当你从消息队列取出一个消息时，ack自动发送，mq就会将消息删除。而为了保证消息的正确处理，我们需要将消息处理修改为手动确认的方式

    return connectionFactory;
  }

  /**
   * 自动生成交换器，队列，队列和交换器的绑定关系
   * 声明多个 Exchanges, Queues, Bindings
   * https://docs.spring.io/spring-amqp/docs/2.1.0.RELEASE/reference/html/_reference.html#collection-declaration
   * @return
   */
  @Bean
  public RabbitAdmin rabbitAdmin() {
    RabbitAdmin rabbitAdmin = new RabbitAdmin(defaultConnectionFactory());
    // 声明交换器

    Exchange exchange = ExchangeBuilder.topicExchange(rabbitProperties.getExchangeName()).durable(true).build();
    rabbitAdmin.declareExchange(exchange);

    // 声明队列
    Queue queue = QueueBuilder.durable(rabbitProperties.getQueueName()).build();

    rabbitAdmin.declareQueue(queue);

    // 将队列和交换器绑定
    Binding binding = BindingBuilder.bind(queue).to(exchange).with(rabbitProperties.getRoutingKey()).noargs();
    rabbitAdmin.declareBinding(binding);

    return rabbitAdmin;
  }

  /**
   * 模板方法 - 必须是prototype类型,不然每次回调都是最后一个内容
   * @return
   */
  @Bean(name = RABBIT_TEMPLATE)
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(defaultConnectionFactory());
    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    return rabbitTemplate;
  }

  /**
   * 配置接收端属性
   * @return
   */
  @Bean(name = RABBIT_LISTENER_CONTAINER_FACTORY)
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//    丢弃消息或重新发布到死信队列
//    factory.setDefaultRequeueRejected(false);
    factory.setConnectionFactory(defaultConnectionFactory());
    factory.setAutoStartup(true);
    factory.setPrefetchCount(rabbitProperties.getPrefetchCount());
    factory.setConcurrentConsumers(rabbitProperties.getConcurrentConsumers());
    factory.setMaxConcurrentConsumers(rabbitProperties.getMaxConcurrentConsumers());
    // 确认模式
    factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
    // 接收端类型转化pojo,需要序列化
    factory.setMessageConverter(new Jackson2JsonMessageConverter());

    return factory;
  }
}

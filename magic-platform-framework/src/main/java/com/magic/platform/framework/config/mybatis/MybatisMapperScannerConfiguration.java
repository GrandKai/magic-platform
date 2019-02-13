package com.magic.platform.framework.config.mybatis;

import com.magic.platform.framework.mapper.BaseMapper;
import java.util.Properties;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author: GrandKai
 * @create: 2018-05-06 3:47 PM
 */
@Configuration
// 必须在 MybatisConfiguration 注册后再加载 MapperScannerConfigurer FIXME: 否则会报错(经验证未报错)
@AutoConfigureBefore(value = {MybatisConfiguration.class})
public class MybatisMapperScannerConfiguration {

    public static final String TK_MAPPER_SCANNER_CONFIGURER = "tkMapperScannerConfigurer";

    @Bean(name = TK_MAPPER_SCANNER_CONFIGURER)
    public MapperScannerConfigurer mapperScannerConfigurer() {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        // This class supports filtering the mappers created by either specifying a marker interface or an annotation
        // The annotationClass property specifies an annotation to search for.
        // The markerInterface property specifies a parent interface to search for
        // If both properties are specified, mappers are added for interfaces that match either criteria.
        // By default, these two properties are null, so all interfaces in the given basePackage are added as mappers.
        // FIXME: 标记接口的作用 mapperScannerConfigurer.setMarkerInterface(BaseMapper.class); mapperScannerConfigurer.setAnnotationClass();

        mapperScannerConfigurer.setBasePackage(MybatisConfiguration.BASE_PACKAGE);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(MybatisConfiguration.SQL_SESSION_FACTORY);
        // TODO: 待验证，只能使用一个 (已验证)
         mapperScannerConfigurer.setSqlSessionTemplateBeanName(MybatisConfiguration.SQL_SESSION_TEMPLATE);

        Properties properties = new Properties();
        // 这里要特别注意，不要把 BaseMapper 放到 basePackage 中，也就是不能同其他 Mapper 一样被扫描到
        // 初始化扫描器的相关配置，这里我们要创建一个 Mapper 的父类
        // FIXME: 将该接口及其父接口所有的查询方法添加进来
        properties.setProperty("mappers", BaseMapper.class.getName());

        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");

        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
}

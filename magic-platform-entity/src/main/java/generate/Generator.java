package generate;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @version 1.9.10
 * @作者：niexiaohui
 * @创建时间：2016年11月22日
 * @修改记录：
 * @since 1.9.10
 */
public class Generator {
    public static void main(String[] args) {
        try {
            // MBG 执行过程中的警告信息
            List<String> warnings = new ArrayList<String>();
            // 生成的代码重复时，覆盖原代码
            boolean overwrite = true;
            // 读取 MBG 配置文件
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("mybatis/generatorConfig.xml");

            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);

            for (String warning : warnings) {
                System.out.println(warning);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

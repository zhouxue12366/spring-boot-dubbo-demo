package com.softisland.demo.common.provider;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 通过main方法启动服务者
 * 注意这两个配置类必须放在目录的最前面,否则其他包下面的配置命令@Configuration等无法自动获取加载,
 * 可以使用注解@ComponentScan(basePackages={"com.softisland","com......"})来解决指定扫描spring注解命令的路径
 * @Title provider_Application.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年2月27日 下午5:37:36
 * @version V1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
//@EnableTransactionManagement//启动事物加载
@ComponentScan(basePackages={"com.softisland"})
@ImportResource("classpath:dubbo-demo-provider.xml")//扫描加载dubbo的配置文件
public class Provider_Application {
	
	@Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }
	
	/**
	 *  如果使用main方法启动项目的话,需要将pom.xml中的移除嵌入式tomcat插件注释;
	 * 相反,如果需要用自己的tomcat启动,只需要在pom.xml中移除嵌入式tomcat插件打开;
	 * @Title main
	 * @Description TODO  
	 * @param args
	 * @throws IOException 
	 * @since 2018年3月1日 下午4:43:01
	 */
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Provider_Application.class, args);
		System.out.println("provider*****************started");
    }
}

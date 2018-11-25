package cn.com.config;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import cn.com.taiji.bean.Person03;

//使用@PropertySource指定外部配置文件，用${}取出外部配置文件的值
@PropertySource(value= {"classpath:/person03.properties"})
@Configuration
public class Person03Config {

	@Bean
	public Person03 person03() {
		
		return  new Person03();
	}
}

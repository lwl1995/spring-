package cn.com.config;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.bean.Person02;
@Configuration
public class ValueConfig {
	
	@Bean
	public Person02 person02() {
		
		return new Person02();
	}

}

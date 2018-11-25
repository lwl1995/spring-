package cn.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.bean.Car;

@Configuration
public class CarConfig {

	@Bean(initMethod="init",destroyMethod="destory")
	public Car car() {
		
		return new Car();
				
	}
}

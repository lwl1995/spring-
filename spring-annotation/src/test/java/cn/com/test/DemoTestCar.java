package cn.com.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.config.CarConfig;

public class DemoTestCar {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
		System.out.println("测试方法");
		
		//容器关闭，会运行销毁的方法
		context.close();
	}
}

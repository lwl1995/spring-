package cn.com.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.config.CarConfig;

public class DemoTestCar {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
		System.out.println("���Է���");
		
		//�����رգ����������ٵķ���
		context.close();
	}
}

package cn.com.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.config.ValueConfig;
import cn.com.taiji.bean.Person02;

public class DemoTestValue {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValueConfig.class);
		Person02 person02 = (Person02) context.getBean("person02");
		System.out.println(person02);
	}
}

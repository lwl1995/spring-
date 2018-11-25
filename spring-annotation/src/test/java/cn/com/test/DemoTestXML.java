package cn.com.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.bean.Person;


//以下为xml文件的注入方式
public class DemoTestXML {
	
	@Test
	public void main() {
		//返回的对象为ApplicationContext，没法输出容器中bean的数量、bean的名字
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		//返回对象为ClassPathXmlApplicationContext，可以输出容器中bean的数量、bean的名字
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//bean的数量
		int count = context.getBeanDefinitionCount();
		System.out.println(count);
		//bean的名字
		String[] names = context.getBeanDefinitionNames();
		for(String string : names) {
			System.out.println(string);
		}
		
	}
}

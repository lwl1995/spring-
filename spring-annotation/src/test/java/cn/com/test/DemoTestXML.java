package cn.com.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.bean.Person;


//����Ϊxml�ļ���ע�뷽ʽ
public class DemoTestXML {
	
	@Test
	public void main() {
		//���صĶ���ΪApplicationContext��û�����������bean��������bean������
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		//���ض���ΪClassPathXmlApplicationContext���������������bean��������bean������
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//bean������
		int count = context.getBeanDefinitionCount();
		System.out.println(count);
		//bean������
		String[] names = context.getBeanDefinitionNames();
		for(String string : names) {
			System.out.println(string);
		}
		
	}
}

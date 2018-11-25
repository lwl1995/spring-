package cn.com.taiji.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person03 {
	
	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person03 [name=" + name + ", age=" + age + "]";
	}
	public Person03(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person03() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

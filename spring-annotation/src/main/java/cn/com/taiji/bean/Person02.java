package cn.com.taiji.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person02 {

	@Value("lisi")
	private String name;
	
	@Value("23")
	private Integer age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person02 [name=" + name + ", age=" + age + "]";
	}
	public Person02(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person02() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

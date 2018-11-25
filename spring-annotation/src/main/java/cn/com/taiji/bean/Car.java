package cn.com.taiji.bean;

public class Car {

	public Car() {
		System.out.println("car constructor...");
	}
	
	//对象被创建的时候就调用
	public void init() {
		System.out.println("car init....");
	}
	
	//调用close方法的时候会被使用
	public void destory() {
		System.out.println("car destory ...");
	}

}

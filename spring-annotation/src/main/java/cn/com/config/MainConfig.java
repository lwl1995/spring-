package cn.com.config;

import org.junit.internal.Classes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.sun.glass.ui.CommonDialogs.Type;

import cn.com.taiji.bean.Person;

//配置类==配置文件xml，配置类需要加@Configuration注解
@Configuration
@ComponentScan(value = "cn.com.taiji",excludeFilters= {
		@Filter(type=FilterType.ANNOTATION,classes= {Controller.class,Service.class})})//这个注解相当于<context:component-scan base-package=""></context:component-scan>,扫描@Controller @Service @Repository @Component这四个任何一个注解
public class MainConfig {

	@Bean("person02")             //这样以person02为Person的名字 
	public Person person() {      //Person对应xml文件的class person对应xml的id
		
		return new Person("liuwenlong",20);
	}
	
}

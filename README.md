# spring-
taiji

### **Spring项目上周总结：**

##### 一.用xml方式注入bean

1.先写一个实体类Person

```java
public class Person {

	private String name;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

```
2.写一个spring的配置文件beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<bean id="person" class="cn.com.taiji.bean.Person">
        
		<property name="name" value="刘文龙"></property>
		<property name="age" value="23"></property>
        
	</bean>
	
	
</beans>
```

3.写一个测试类

```java

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


```
##### 二.用注解的方式注入bean

1.新建一个实体类

	package cn.com.taiji.bean;
	
	public class Person {
	private String name;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		}
	}
	

2.创建一个配置类

	//配置类==配置文件xml，配置类需要加@Configuration注解
	@Configuration
	@ComponentScan(value = "cn.com.taiji",excludeFilters= {
			@Filter(type=FilterType.ANNOTATION,classes= {Controller.class,Service.class})})//这个注解相当于<context:component-scan base-package=""></context:component-scan>,扫描@Controller @Service @Repository @Component这四个任何一个注解
	public class MainConfig {
	@Bean("person02")             //这样以person02为Person的名字 
	public Person person() {      //Person对应xml文件的class person对应xml的id
		
		return new Person("刘文龙",23);
		}
	}

3.创建一个测试类

	public class DemoTestAnnotationConfig {
		
	@Test
	public void main() {			//返回对象也可以为ApplicationContext
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = context.getBean(Person.class);
		System.out.println(person);
		int count = context.getBeanDefinitionCount();
		System.out.println(count);
		String[] names = context.getBeanDefinitionNames();
		for(String string : names) {
			System.out.println(string);
		}
	  }
	}
	

##### 三.Init和destroy方法

1.创建一个实体类Car

```java
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


```

2.创建一个配置类

```java
@Configuration
public class CarConfig {

	@Bean(initMethod="init",destroyMethod="destory")
	public Car car() {
		
		return new Car();
				
	}
}

```

3.创建测试类

```java
public class DemoTestCar {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
		System.out.println("测试方法");
		
		//容器关闭，会运行销毁的方法
		context.close();
	}
}
```

##### 四.自动注入@Autowired

在dao层

```java
简述：在dao层 service层 controller层各建一个方法

@Repository   //默认首字母小写
public class BookDao {

	private String lable="1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "BookDao [lable=" + lable + "]";
	}
	
	
}
```

在service层

```java
@Service
public class BookService {

	//明确指定扫描
	//@Qualifier("bookDao02")
	@Autowired
	private BookDao bookDao;
	
	
	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}

}
```

在controller层

```java
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	public void service() {
		System.out.println("Service.................");
	}
}
```

测试类

```java
public class DemoTestAutowired {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredCongfig.class);
		BookService service = context.getBean(BookService.class);
		System.out.println(service);	
		
	}
}

```

##### 五.@ComponmentScan注解的使用

实体类

```java
public class Person {

	private String name;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

```

配置类

```java
//配置类==配置文件xml，配置类需要加@Configuration注解
@Configuration
@ComponentScan(value = "cn.com.taiji")
public class MainConfig {

	@Bean("person02")             //这样以person02为Person的名字 
	public Person person() {      //Person对应xml文件的class person对应xml的id
		
		return new Person("liuwenlong",20);
	}
	
}

```

测试类

```
public class DemoTestComponentScan {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] names = context.getBeanDefinitionNames();
		for(String string : names) {
			System.out.println(string);
		}
		
	}
}

```

##### 六.@PropertySource指定外部配置文件

```java
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
```

配置类

```java
//使用@PropertySource指定外部配置文件，用${}取出外部配置文件的值
@PropertySource(value= {"classpath:/person03.properties"})
@Configuration
public class Person03Config {

	@Bean
	public Person03 person03() {
		
		return  new Person03();
	}
}

```

外部文件person03.properties

```java
name=liuwenlong
age=23
```

测试类

```java

public class DemoTestPerson03 {

	
	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Person03Config.class);
		Person03 bean = (Person03) context.getBean("person03");
		System.out.println(bean);
	}
	
}
```

##### 七.@Value注解的使用

实体类

```java
public class Person02 {

	@Value("刘文龙")
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
```

配置类

```java
@Configuration
public class ValueConfig {
	
	@Bean
	public Person02 person02() {
		
		return new Person02();
	}

}
```

测试类

```java
public class DemoTestValue {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new 			AnnotationConfigApplicationContext(ValueConfig.class);
		Person02 person02 = (Person02) context.getBean("person02");
		System.out.println(person02);
	}
}

```




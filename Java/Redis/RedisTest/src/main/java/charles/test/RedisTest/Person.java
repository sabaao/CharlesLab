package charles.test.RedisTest;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8520135654850230338L;
	
	public Person(){
		
	}
	
	public Person(String name,int age){
		super();
		this.name = name;
		this.age = age;
	}
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
   }
	
}

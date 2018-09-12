package vo;

public class Person {
	private String name;
	private int age;
	private String Phone;
	
	public Person() {
		System.out.println("Person의 생성자입니다.");
	}
	
	
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
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", Phone=" + Phone + "]";
	}
	
	
}

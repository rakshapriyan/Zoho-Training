package task.file;

public class SamplePOJO {
	
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SamplePOJO(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public SamplePOJO() {
		
	}
	@Override
	public String toString() {
		return "SamplePOJO [age=" + age + ", name=" + name + "]";
	}
}

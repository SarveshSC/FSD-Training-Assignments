package fundamentals;

public class Student {
	int sId;
	String sName;
	
	public Student() {
		super();
	}
	
	
	public Student(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

	public void Hello() {
		System.out.println("Hello " + this.sName);
	}
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.sId = 101;
		s1.sName = "Ron";
		
		System.out.println(s1.sId + " " + s1.sName);
		s1.Hello();
		
		Student s2 = new Student();
		System.out.println(s2.sId + " " + s2.sName);
	}
}

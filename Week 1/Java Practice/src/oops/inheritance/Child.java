package oops.inheritance;

public class Child extends Parent{
	int cid = 99;
	public Child() {
		super();
		System.out.println("Child object created");
	}
	
	public void m2() {
		System.out.println("M2() from Child Class");
	}
	@Override
	public String toString() {
		return "Child toString method called";
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c);
	}
}

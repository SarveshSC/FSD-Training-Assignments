package strings;

public class StringPractice {
	public static void main(String[] args) {

		StringPractice d1 = new StringPractice();

		StringPractice d2 = new StringPractice();

		System.out.println(d1.equals(d2)); // false

		String str1 = new String("hello world");
		String str2 = new String("hello world");

		System.out.println("Values : " + str1.equals(str2));
		System.out.println(str1 == str2); // it compares hashcode

		String str3 = "Lewis";
		String str4 = "lewis";

		System.out.println("Values SCP :" + str3.equals(str4));
		System.out.println(str3 == str4);// it compares hashcode
		
//		--------------------------------------------------------------------------------------

		String s1 = new String("hello");

		s1 = s1.concat(" world");

		System.out.println(s1);
		s1 = s1 + " again";

		System.out.println(s1);

		StringBuffer sb1 = new StringBuffer("hello");

		sb1.append(" world");

		String name1 = new String("A"); // 65
		String name2 = new String("B"); // 66

		System.out.println(name1.compareTo(name2)); // compares ascii value
		
		StringBuilder sb2 = new StringBuilder("hello");
		sb2.append(" world");
		
		String name3 = new String("a");
		String name4 = new String("B");
		
		System.out.println(name3.compareToIgnoreCase(name4));

	}
}

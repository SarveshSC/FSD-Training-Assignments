package presentation;

import java.util.List;
import java.util.Scanner;

import dao.DeptDAOImpl;
import dao.IDeptDAO;
import entity.Department;

public class Client {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		IDeptDAO dao = new DeptDAOImpl();

		boolean flag = true;

		while (flag) {
			System.out.println("****WELCOME DMS ***");
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SELECT BY ID");
			System.out.println("5. SELECT ALL");
			System.out.println("6. EXIT");

			int choice = scanner.nextInt();
			Department dept = null;
			int count = 0;

			switch (choice) {
			case 1:
				dept = readData();
				count = dao.insert(dept);

				System.out.println(count + " record inserted successfully");
				break;
				
			case 2:
				dept = readData();
				count = dao.update(dept);
				System.out.println(count + " record(s) updated successfully");
				break;
				
			case 3:
				System.out.println("Enter the department no of the department you want to delete ");
				int deptId = scanner.nextInt();
				count = dao.deleteOne(deptId);
				System.out.println(count + " record(s) deleted successfully");
				break;
				
			case 4:
				deptId = scanner.nextInt();
				System.out.println(dao.selectOne(deptId));
				break;
				
			case 5:
				List<Department> list = dao.selectAll();
				list.stream().forEach(System.out::println);
				break;
				
			case 6:
				flag = false;
				System.out.println("Thankyou! Visit Again");
				break;

			default:
				break;
			}

		}

	}

	public static Department readData() {

		System.out.println("Enter DNO");
		int dno = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter DNAME");
		String dname = scanner.nextLine();

		System.out.println("Enter LOCATION");
		String location = scanner.nextLine();

		Department dept = new Department(dno, dname, location);

		return dept;
	}

}

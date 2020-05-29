package studentDatabaseApp;

import java.util.Scanner;

public class StudentDBApp {

	public static void main(String[] args) {
		System.out.println("Please enter number of students: ");
		Scanner in = new Scanner(System.in);
		int numStudents = in.nextInt();
		
		for (int i=0; i<numStudents; i++) {
			Student s = new Student();
			System.out.println(s);
		}
		
	}
}

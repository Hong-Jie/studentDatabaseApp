package studentDatabaseApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Student {
	private String name;
	private int grade;
	private int id;
	private String[] courses = {"Histroy","Mathematics","English",
	                            "Chemistry","Computer Science"};
	private ArrayList<Integer> enrolled = new ArrayList<Integer>();
	private int balance;
	
	public Student() {
		// Ask for student's name
		this.name = askForName();
		
		// Ask for their grade to generate id
		this.grade = askForGrade();
		this.id = generateID(this.grade);
		
		// Ask for the courses enrolled
		askForEnrolled();
		
		this.balance = this.enrolled.size()*600;
	};
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", id=" + id + ", courses=" + Arrays.toString(courses)
				+ ", enrolled=" + enrolled + ", balance=" + balance + "]";
	}

	public String askForName() {
		System.out.println("Please enter your name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		return name;
	}
	
	public int askForGrade() {
		System.out.println("Please enter your grade: ");
		Scanner in = new Scanner(System.in);
		int grade = in.nextInt();
		while (grade<1 || grade>4) {
			System.out.println("Invalid grade level! Please enter again: ");
			grade = in.nextInt();
		}
		return grade;
	}
	
	public int generateID(int grade) {
		int suffix = (int) (Math.random()*10000);
		return grade*10000+suffix;
	}
	
	public void askForEnrolled() {
		System.out.println("Course Indices:");
		for (int i=0; i<this.courses.length; i++) {
			System.out.println(i+": "+this.courses[i]);
		}
		System.out.println("Please enter indices of enrolled courses: ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Scanner scan = new Scanner(s);
		int count = 0;
		while (scan.hasNextInt() && count<5) {
			int index = scan.nextInt();
			if (index>=0 && index<this.courses.length) {
				this.enrolled.add(index);
				count++;
			}
		}
		scan.close();
	}
	
}

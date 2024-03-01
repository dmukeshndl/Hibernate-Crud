package com.learn.hibernate.example.HibernateProjectCURD;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student5 {
	@Id
	int rollNo;
	String name;
	int age;
	int marks;
	
	public Student5() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student5(int rollNo, String name, int age, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student5 [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	
}

package com.learn.hibernate.example.HibernateProjectCURD;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	//Creating the Scanner Class Object
        Scanner sc = new Scanner(System.in);
        
        //Creating the Object of Configuration Object
        Configuration cfg = new Configuration().configure();
        
        //Building the SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Opening the Session
        Session session = factory.openSession();
        
        // Begin Transaction
        Transaction transaction = session.beginTransaction();
        
        boolean b = true;
        
        // Creating the infinite Loop for continuously running the program
        while(b) {
        	System.out.println("Enter 1 for insertion, Enter 2 for updation, Enter 3 for deletion, "
        			+ "Enter 4 for retrival and any other for termination the program");
        	
        	int a = sc.nextInt();
        	
        	// Creating Switch Condition for calling the method According to the Option
        	switch(a)
			{
			case 1:
				create(session, sc);
				break;
			case 2:
				update(session, sc);
				break;
			case 3:
				delete(session, sc);
				break;
			case 4:
				retrive(session, sc);
				break;
			default:
				b=false;
				transaction.commit();
				break;


			}
		}
		sc.close();
	}
	public static void create(Session session, Scanner sc) 
	{
		System.out.println("Enter number of rows you want to store : ");
		int rows = sc.nextInt();
		Student5 arr[] = new Student5[rows];

		for(int i =0;i<rows;i++)
		{
			System.out.println("Enter roll no");
			int rollNo = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter age");
			int age = sc.nextInt();
			System.out.println("Enter marks");
			int marks = sc.nextInt();

			arr[i] = new Student5(rollNo, name, age, marks);
			session.save(arr[i]);
			System.out.println("Data saved");
		}

	}
	public static void update(Session session, Scanner sc) 
	{
		try {
			System.out.println("Enter roll no where you want to update:");
			int rollNo = sc.nextInt();
			Student5 st = session.get(Student5.class, rollNo);

			System.out.println("What do you want to update : name, age, marks");
			String str = sc.next();

			if(str.equals("name"))
			{
				System.out.println("Enter new name to update");
				String name = sc.next();
				st.setName(name);
			}
			else if(str.equals("age"))
			{
				System.out.println("Enter new age to update");
				int age = sc.nextInt();
				st.setAge(age);
			}
			else if(str.equals("marks"))
			{
				System.out.println("Enter new marks to update");
				int marks = sc.nextInt();
				st.setMarks(marks);
			}
			else
			{
				System.out.println("Wrong choice:");
			}
			session.save(st);
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered wrong input");
		}

	}
	public static void delete(Session session, Scanner sc) 
	{
		try {
			System.out.println("Enter the roll no for which you want to delete the data");
			int rollNo = sc.nextInt();

			Student5 st = session.get(Student5.class, rollNo);
			session.remove(st);
			System.out.println("Data is deleted");
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered wrong input");
		}

	}
	public static void retrive(Session session,Scanner sc) 
	{
		try {
			System.out.println("Enter the roll no for which you want to see data");
			int rollNo = sc.nextInt();

			Student5 s1 = session.get(Student5.class, rollNo);
			
			System.out.println(s1);
			System.out.println();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong input");
		}

        }  
 }

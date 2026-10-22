package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       // Student s1 = new Student();
//        s1.setRollNo(104);
//        s1.setsName("Gaurav");
//        s1.setsAge(21);

//        Laptop l1 = new Laptop();
//        l1.setLid(4);
//        l1.setBrand("asus");
//        l1.setModel("Strix");
//        l1.setRam(32);

//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(8);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(3);
//        l3.setBrand("Apple");
//        l3.setModel("Macbook");
//        l3.setRam(32);
//
//        Alien a1= new Alien();
//        a1.setAid(101);
//        a1.setAname("abc");
//        a1.setTech("python");
//       a1.setLaptops(Arrays.asList(l1,l2));
//
//        Alien a2= new Alien();
//        a2.setAid(102);
//        a2.setAname("xyz");
//        a2.setTech("java");
//        a2.setLaptops(Arrays.asList(l3));








//        Configuration cfg = new Configuration();
//        cfg.configure();
//        cfg.addAnnotatedClass(Student.class);

        SessionFactory sf =  new Configuration().addAnnotatedClasses(Laptop.class).configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.persist(s1);   // Save entity
        //tx.commit();           // Commit AFTER persist





        // select * from Laptop where ram=32 ---> SQL Query
        // from laptop where ram=32 --->HQL Query
        List<Laptop> laptops = session
                .createQuery("from Laptop where brand = 'Asus'", Laptop.class)
                .list();


       // Laptop l1 = session.find(Laptop.class, 3);
        System.out.println(laptops);//to fetch the Data

//        if (s1 != null) {
//            s1.setsAge(30);   // Update age
//        }
//        session.remove(s1);
    //  session.persist(l1);
//      session.persist(l2);
//      session.persist(l3);
//
//
//      session.persist(a1);
//      session.persist(a2);


        tx.commit();
        session.close();
        sf.close();

        System.out.println("Student saved successfully!");
    }
}
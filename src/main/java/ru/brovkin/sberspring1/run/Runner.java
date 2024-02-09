package ru.brovkin.sberspring1.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.brovkin.sberspring1.configuration.JavaContext;
import ru.brovkin.sberspring1.data.Teacher;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext javaContext = new AnnotationConfigApplicationContext(JavaContext.class);
        Teacher javaContextTeacher = javaContext.getBean("teacher", Teacher.class);
        System.out.println("Java context Beans:");
        System.out.println(javaContextTeacher);
        javaContextTeacher.getStudents().forEach(System.out::println);

        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("XmlContext.xml");
        Teacher xmlContextTeacher = xmlContext.getBean("teacher", Teacher.class);
        System.out.println("\nXML context Beans:");
        System.out.println(xmlContextTeacher);
        xmlContextTeacher.getStudents().forEach(System.out::println);
    }
}
package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program Started" );
        
     //   ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
       ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
       StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
       
     // Student student = new Student();

/*
     //insert 
      student.setId(753);
      student.setName("Pa");
      student.setCity("Gurg");
      int result = studentDao.insert(student);
      System.out.println("Student added"+ result);
        
 */ 
      
 /*
      //update 
      student.setId(753);
      student.setName("Minakshi");
      student.setCity("Delhi");
      int result= studentDao.change(student);
      System.out.println("Student updated :"+result);
      
 */
  /*    //delete
      int result = studentDao.delete(753);
      System.out.println("Student deleted :"+result);
 */     
        /*
         //simple insert not according to industry standard
        JdbcTemplate template= context.getBean("jdbcTemplate",JdbcTemplate.class);
        
        //insert Query
       String query = "insert into student(id,name,city) value(?,?,?)";
       //fire query
       int result = template.update(query,789,"Shyam","MAdras");
        System.out.println("number of recored inserted :"+result);
        */
/*       
       //get single Student
        Student student = studentDao.getStudent(102);
        System.out.println(student);
  */
    
       //get all Student
       List<Student> allStudent = studentDao.getAllStudent();
       for (Student student : allStudent) {
    	   System.out.println(student);
		
	}
    }
}

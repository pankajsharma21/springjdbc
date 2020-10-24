/**
 * 
 */
package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

/**
 * @author Pankaj Sharma
 *
 */
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
   JdbcTemplate jdbcTemplate;
   
	public int insert(Student student) {
		 //insert Query
		String query = "insert into student(id,name,city) value(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	public int change(Student student) {
		// Update
		String query = "update student set name=? ,city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	public int delete(int studentId) {
		//Delete
		String query = "delete from student where id=?";
		int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}
	
	public Student getStudent(int studentId) {
		// fetch single object
		
				String query = "select *from student where id=?";
				RowMapper<Student> rowMapper = new RowMapperImpl(); // we can also use anyoms class insted of this rowmapper class implement.
				Student student=this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
				return student;
	}
	
	public List<Student> getAllStudent() {
		// fetching multiple object
		String query = "select *from student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
	
		return jdbcTemplate;
	}
     //we can use @Autowired on setter also
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	

	

	


	

	
}

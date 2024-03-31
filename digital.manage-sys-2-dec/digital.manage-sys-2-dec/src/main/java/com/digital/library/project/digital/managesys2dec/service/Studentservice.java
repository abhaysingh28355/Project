package com.digital.library.project.digital.managesys2dec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.digital.library.project.digital.managesys2dec.Repo.StudentRepo;
import com.digital.library.project.digital.managesys2dec.models.Book;
import com.digital.library.project.digital.managesys2dec.models.Student;

public class Studentservice {
	
	@Autowired
	StudentRepo studentrepo;

	public void CreateStudent(Student student) {
		studentrepo.save(student);
		
	}

	public Student getStudentById(int studentid) {
		return studentrepo.findById(studentid).orElse(null);
		
	}
	public List<Student> getstuents(){
		return studentrepo.findAll();
	
}

}

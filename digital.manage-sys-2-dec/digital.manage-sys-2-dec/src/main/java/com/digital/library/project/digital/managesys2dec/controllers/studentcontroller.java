package com.digital.library.project.digital.managesys2dec.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.library.project.digital.managesys2dec.createRequest.studentcreateRequest;
import com.digital.library.project.digital.managesys2dec.models.Author;
import com.digital.library.project.digital.managesys2dec.models.Book;
import com.digital.library.project.digital.managesys2dec.models.Student;
import com.digital.library.project.digital.managesys2dec.service.Studentservice;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@Entity
@AllArgsConstructor
@NoArgsConstructor
 @Getter
@Setter
@Builder
@RequestMapping("/student")
public class studentcontroller {
	
	@Autowired
	Studentservice studentservice;

	@PostMapping("/CreateStudent")
	public void CreateStudent(@RequestBody studentcreateRequest studentcreateRequest) {
		studentservice.CreateStudent(studentcreateRequest.to());
	}
	
	@GetMapping("/{Studentid}")
	public Student getStudent(@PathVariable("Studentid") int studentid) {
		return studentservice.getStudentById(studentid);
	}
}

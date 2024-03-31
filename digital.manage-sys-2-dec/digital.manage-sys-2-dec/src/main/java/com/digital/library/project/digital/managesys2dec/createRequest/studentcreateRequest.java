package com.digital.library.project.digital.managesys2dec.createRequest;

import com.digital.library.project.digital.managesys2dec.models.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class studentcreateRequest {

	
	@Positive
	private int age;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	
	public Student to() {
		return Student.builder().age(age).Name(name).email(email).build();
	}
}

package com.digital.library.project.digital.managesys2dec.Repo;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.library.project.digital.managesys2dec.models.Book;
import com.digital.library.project.digital.managesys2dec.models.Student;
import com.digital.library.project.digital.managesys2dec.models.TransactionType;

public interface TransactionRepo extends JpaRepository<Transaction,Integer>{
	
	//Transaction findByTransactionId(int id);
	//List<Transaction> findByStudent(Student student);
	//List<Transaction> findByStudentAndBook(Student student,Book book);
	//List<Transaction> findByStudentorderById(Student student);
	
	List<Transaction> findByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student,Book book,TransactionType transaction);

}

package com.digital.library.project.digital.managesys2dec.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.digital.library.project.digital.managesys2dec.Repo.TransactionRepo;
import com.digital.library.project.digital.managesys2dec.models.Book;
import com.digital.library.project.digital.managesys2dec.models.Student;
import com.digital.library.project.digital.managesys2dec.models.Transaction;
import com.digital.library.project.digital.managesys2dec.models.TransactionStatus;
import com.digital.library.project.digital.managesys2dec.models.TransactionType;

@Service
public class TransactionService {

//	student.book.limit=2
//			book.return.date=7
//			book.fine.day=1

	@Value("${student.book.limit}")
	int studentBookLimit;

	@Value("${book.return.days}")
	int bookReturnDays;

	@Value("${book.fine.day}")
	int bookFineDay;

	@Autowired
	TransactionRepo transactionrepo;

	@Autowired
	Studentservice studentservice;

	@Autowired
	Bookservice bookservice;

	public String issueBook(int bookId, int studentId) throws Exception {

		Student student = studentservice.getStudentById(studentId);

		if (student == null) {
			throw new Exception("Student is not present,Unable to issue a book");
		}

		if (student.getBookList().size() > studentBookLimit) {
			throw new Exception("Student has reached there limit,Unable to issue a book");
		}
		Book book = bookservice.getBookById(bookId);
		if (book == null) {
			throw new Exception("Book is not present in the System,Unable to issue a book");
		}
		if (book.getstudent() != null) {
			throw new Exception("Book is already issued someone else,Unable to issue a book");
		}
		Transaction transaction = Transaction.builder().book(book).student(student)
				.transactionType(TransactionType.ISSUE).transactionStatus(TransactionStatus.PENDING)
				.transactionId(UUID.randomUUID().toString()).build();
		
		transactionrepo.save(transaction);
		try {
		book.setStudent(student);
		bookservice.createbook(book);
		transaction.setTransactionStatus(TransactionStatus.SUCCESS);
		}catch(Exception e){
		book.setStudent(null);
		bookservice.createbook(book);
		transaction.setTransactionStatus(TransactionStatus.FAILED);
		}
		return transaction.getTransactionId()+"Issue Maethod";
	}
		
		public String returnbook(int bookId,int studentid) throws Exception{
			
			Student student = studentservice.getStudentById(studentid);
			Book book = bookservice.getBookById(bookId);
			if(student==null||book==null||book.getstudent()==null||book.getstudent().getstudentId()!=studentId) {
				throw new Exception("book is not present Unable to assign");
			}
			
			
			List<org.hibernate.Transaction> issuedtxns = transactionrepo.findByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);
			Transaction issueTnx = issuedtxns.get(studentid);
			long issueTimeInMs = issueTnx.getUpdatedOn().getTime();
			long currentTimeInMs = System.currentTimeMillis();
			long TimeDiff = currentTimeInMs-issueTimeInMs;
			long DiffInDay = TimeUnit.DAYS.convert(TimeDiff, TimeUnit.MILLISECONDS);
			
			int find = 0;
			if(DiffInDay>bookReturnDays) {
				find = (int)((DiffInDay-bookReturnDays)*bookFineDay);
						
			}
			return null;
			
			Transaction transaction = Transaction.builder().book(book).student(student).fine(find)
					.transactionType(TransactionType.RETURN).transactionStatus(TransactionStatus.PENDING)
					.transactionId(UUID.randomUUID().toString()).build();
			
			transactionrepo.save(transaction);
			
			try {
				book.setStudent(null);
				bookservice.createbook(book);
				transaction.setTransactionStatus(TransactionStatus.SUCCESS);
				
				}catch(Exception e){
					book.setStudent(student);
					bookservice.createbook(book);
					transaction.setTransactionStatus(TransactionStatus.FAILED);
				}
				return transaction.getTransactionId()+"Issue Maethod";
			
		}

	

}

package com.ojas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ojas.dao.BookRepository;
import com.ojas.entity.BookEntity;

@SpringBootApplication
public class SpringDataJpaApplication {

	private static Iterable<BookEntity> saveAll;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringDataJpaApplication.class, args);
	BookRepository bkp=ctx.getBean(BookRepository.class);
	BookEntity be=new BookEntity();
	be.setBid(103);
	be.setBname("java");
	be.setBprice("1000");
	BookEntity be1=new BookEntity();
	be1.setBid(101);
	be1.setBname("python");
	be1.setBprice("1000");
	BookEntity be2=new BookEntity();
	be2.setBid(104);
	be2.setBname("c++");
	be2.setBprice("1000");
	
	List<BookEntity> book=new ArrayList<>();
	book.add(be);
	book.add(be1);
	book.add(be2);
	
//	BookEntity b=bkp.save(be);
//	if(b!=null) {
//		System.out.println(b.getBid()+" "+b.getBname()+" "+b.getBprice());
//	}
//	else {
//		System.out.println("not inserted");
//	}
//	
//	 Iterable<BookEntity> saveAll2 = bkp.saveAll(book);
// if(saveAll2!=null) {
//	 System.out.println("added successfully");
// }
// else{
//	 System.out.println("not added");
// }
//	Optional<BookEntity> findById1 = bkp.findById(107);
//	if(findById1.isPresent()) {
//		BookEntity find=findById1.get();
//		System.out.println(find.getBid()+" "+find.getBname()+" "+find.getBprice());
//	}
//	else {
//		System.out.println("not found");
//	}
	
//	Iterable<BookEntity> findAll1 = bkp.findAll();
//	for(BookEntity b: findAll1) {
//		System.out.println(b);
//	}

	 bkp.deleteById(101);
	
}}
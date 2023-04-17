package com.ojas.dao;

import java.awt.print.Book;

import org.springframework.data.repository.CrudRepository;

import com.ojas.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {

	

}

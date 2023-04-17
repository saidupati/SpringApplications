package com.ojas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ojas.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByPname(String pname);
	Product findByPnameAndPadd(String pname,String padd);
@Query("select pname from Product where pid=3")
	List<String > getProductNames();
}

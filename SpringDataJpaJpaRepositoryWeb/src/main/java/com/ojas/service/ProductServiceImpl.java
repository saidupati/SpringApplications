package com.ojas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.ProductEntity;
import com.ojas.generate.GeneraterPDF;
import com.ojas.model.Product;
import com.ojas.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		// interacr db to store entity data
		ProductEntity pro = new ProductEntity();
//		pro.setPid(product.getPid());
//		pro.setPname(product.getPname());
//		pro.setPprice(product.getPprice());

		BeanUtils.copyProperties(product, pro);
		ProductEntity save = repo.save(pro);
		if (save != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductEntity> findProduct = repo.findAll();
		List<Product> add = new ArrayList<Product>();
		for (ProductEntity pe : findProduct) {
			Product p = new Product();
//			p.setPid(pe.getPid());
//			p.setPname(pe.getPname());
			BeanUtils.copyProperties(pe, p);
			add.add(p);
		}
		return add;
		
		
	}

	@Override
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> findById = repo.findById(pid);
		ProductEntity productEntity = findById.get();
		Product p = new Product();
		BeanUtils.copyProperties(productEntity, p);
		
		return p;

	}

	@Override
	public int updateProduct(int pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> findById = repo.findById(pid);
		ProductEntity productEntity = findById.get();
		boolean flag = false;
		if (findById != null) {
			repo.deleteById(pid);
			flag = true;
		}
		return flag;
	}

}

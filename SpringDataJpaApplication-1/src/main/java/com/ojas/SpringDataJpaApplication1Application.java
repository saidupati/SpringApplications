package com.ojas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ojas.dao.ProductRepository;
import com.ojas.entity.Product;

@SpringBootApplication
public class SpringDataJpaApplication1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringDataJpaApplication1Application.class, args);
		ProductRepository bean = ctx.getBean(ProductRepository.class);
//		Product p=new Product();
//		p.setPid(1);
//		p.setPname("prasanna");
//		p.setPadd("hyd");
//		
//		Product savePro = bean.save(p);
//		if(savePro!=null) {
//			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPadd());
//		}
//		else {
//			System.out.println("not ADDED");
//		}
//	
//		List<Product> pro=new ArrayList<>();
//		pro.add(new Product(2,"sai","wgl"));
//		pro.add(new Product(3,"shiva","vzg"));
//		pro.add(new Product(4,"anand","alwal"));
//		pro.add(new Product(5,"aruna","delhi"));
//		pro.add(new Product(6,"yamini","suryapet"));
//		
//		List<Product> saveAll = bean.saveAll(pro);
//		if(saveAll!=null) {
//			System.out.println(pro.get(2)+" "+pro.get(3)+pro.get(4));
//		}
//		else {
//			System.out.println("not inserted");
//		}
		
//		List<Product> findAll = bean.findAll();
//		findAll.stream().forEach(s->System.out.println(s.getPid()+" "+s.getPname()+" "+s.getPadd()));
//	
//	Optional<Product> findById = bean.findById(2);
//	Product product = findById.get();
//	if(product!=null) {
//		System.out.println(product.getPid()+" "+product.getPname()+" "+product.getPadd());
//	}
//	else {
//		System.out.println("not found");
//	}
		
//		Product find = bean.findByPname("yamini");
//		if(find!=null) {
//			System.out.println(find.getPid()+" "+find.getPname()+" "+find.getPadd());
//		}
//		else {
//			System.out.println("not found");
//		}
//		Product find = bean.findByPnameAndPadd("yamini", "suryapet");
//	      if(find!=null) {
//	    	  System.out.println(find.getPid()+" "+find.getPadd());
//	      }
		List<String> p = bean.getProductNames();
		p.stream().forEach(s->System.out.println(s.toString()));;
		}
     
}

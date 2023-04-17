package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.generate.GenerateExcel;
import com.ojas.generate.GeneraterPDF;
import com.ojas.generate.SendAttachment;
import com.ojas.model.Product;
import com.ojas.service.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl impl;

	@RequestMapping(value = { "/", "/loadForm" })

	public String loadForm(Model m) {
		Product p = new Product();
		m.addAttribute("product", p);

		return "addProduct";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)

	public String handleAddProduct(@ModelAttribute("product") Product product, Model m) {

		String saveProduct = impl.saveProduct(product);
		String msg = "";
		if (saveProduct != null) {
			msg = "added successfully";
		} else {
			msg = "not added";
		}
		m.addAttribute("msg",msg);
		return "addProduct";

	}

	@RequestMapping("/viewProducts")
	public String viewlAllProducts(Model m) {
		List<Product> allProducts = impl.getAllProducts();
		m.addAttribute("products", allProducts);
		return "viewProducts";

	}

	@RequestMapping("/viewProduct")
	public String viewById(@RequestParam int pid, Model m) {
		Product productById = impl.getProductById(pid);
		m.addAttribute("product", productById);
		return "viewProduct";

	}

	@RequestMapping("/delete")
	public String deleteProduct(Model m) {
		boolean deleteProduct = impl.deleteProduct(2);
		m.addAttribute(deleteProduct);
		return "delete";
	}

	@RequestMapping("/EditProduct/{pid}")
	public String editProduct(@PathVariable int pid, Model m) {
		Product productById = impl.getProductById(pid);
		m.addAttribute("product", productById);
		return "EditProduct";

	}

	@RequestMapping(value = "/EditProduct", method = RequestMethod.POST)
	public String editSave(@RequestParam("product") Product product, Model m) {
		String saveProduct = impl.saveProduct(product);
		String msg = "";
		if (saveProduct != null) {
			msg = "updated successfully";
		} else {
			msg = "not updated";
		}
		m.addAttribute(msg);
		return "redirect:/viewProducts";
	}
	@RequestMapping("/pdf")
	public String pdf(Model m) {
		List<Product> allProducts = impl.getAllProducts();
		boolean generatePdf = GeneraterPDF.GeneratePdf(allProducts);
		String msg="";
		if(generatePdf) {
			msg="pdf generated";
		}
		m.addAttribute("msg", msg);
		return "viewProducts";
		
	}
	@RequestMapping("/excel")
	public String excel(Model m) {
		List<Product> allProducts = impl.getAllProducts();
		boolean excelReport = GenerateExcel.excelReport(allProducts);
		String msg="";
		if(excelReport) {
			msg="excel generated";
		}
		m.addAttribute("msg", msg);
		return "viewProducts";
	}
	@RequestMapping("/mail")
	public String mail(Model m) {
   String fileName=	"C:/Users/sd22279/Documents/pdf-excel/product.pdf";	
   String email="adarshperumalla@gmail.com";
   boolean emailSend = SendAttachment.emailSend(email, fileName);
   String msg="";
   if(emailSend) {
	   msg="mail send";
   }
   m.addAttribute("msg", msg);
		return "viewProducts";
		
	}
}
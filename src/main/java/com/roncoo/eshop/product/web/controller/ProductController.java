package com.roncoo.eshop.product.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.product.model.Product;
import com.roncoo.eshop.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/add")
	public String add(Product product,String operationType) {

		try {
			productService.add(product,operationType);
		} catch (Exception e) {
			e.addSuppressed(e);
			return "error";
		}

		return "success";
	}

	@GetMapping("/update")
	public String update(Product product,String operationType) {
		try {
			productService.update(product,operationType);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	@GetMapping("/delete")
	public String delete(long id,String operationType) {
		try {
			productService.delete(id,operationType);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	@GetMapping("/findById")
	@ResponseBody
	public Product findById(Long id) {
		return productService.findById(id);
	}

	@GetMapping("/findByIds")
	public List<Product> findByIds(String ids) {
		return productService.findByIds(ids);
	}

}

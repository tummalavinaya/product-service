package com.krivis.ecom.productService;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;



@RestController
public class ProductController {
	@Autowired
	ProductJdbcDao productJdbcDao;
	/*
	@GetMapping("/products")
	public String getProductDescription() {
		return "product description";		
	}
	@GetMapping(path="/product/{productId}", produces = APPLICATION_XML_VALUE)
	public Product getProduct(@PathVariable int productId) {	
		Product p1 = new Product();
		p1.setProductId(10);
		p1.setTitle("tshirt");
		p1.setProductDesc("full sleeves");
		return p1;	   
	}
	
	
	@GetMapping(path ="/product")
	public List<Product> getAllProducts(){		
		return productJdbcDao.findAll();		
	}
	
	
	@PostMapping(path="/products", consumes = APPLICATION_XML_VALUE)
	public Product createProduct(@RequestBody Product product) {
		return product;		
	}
	@PutMapping(path="/products",consumes = APPLICATION_XML_VALUE)
	public Product updateProduct(@RequestBody Product product) {
		return product;
	}
	@DeleteMapping("/products/{productId}")
	public String deleteProductbyId(@PathVariable int productId) {
		return "successfully deleted";
	}
	@DeleteMapping("/products")
	public String deleteProductbyProductObject(@RequestBody Product product) {
		return "object  deleted";
	}*/
	
	@GetMapping("/products")
	public List<Product> getAll() {
		return productJdbcDao.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getOne(@PathVariable int id) {
		return productJdbcDao.findOne(id);
	}
	
	@PostMapping("/products")
	public int createProduct(@RequestBody Product product) {
		int rowscreated =  productJdbcDao.save(product);
		if(rowscreated >= 1)
			return rowscreated;
		else
			return 0;
	}
	
	@PutMapping("/products")
	public String updateByObject(@RequestBody Product product) {
		int rowsUpdated = productJdbcDao.update(product);
		if(rowsUpdated > 0)
			return "rows updated successfully"+ rowsUpdated;
		else
			return "update failure";
	}
	/*
	@PutMapping("/products/{id}")
	public String updateById(@PathVariable int id, @RequestBody Product product) {
		int rowsUpdated = productJdbcDao.update(id,product);
		if(rowsUpdated > 0)
			return "rows updated successfully  "+ rowsUpdated;
		else
			return "update failure";
	}*/
	
	@DeleteMapping("/products/{id}")
	public String deleteById(@PathVariable int id) {
		int rowsDeleted = productJdbcDao.deleteById(id);
		if(rowsDeleted >=0 )
			return "No: of rows deleted successfully are :"+rowsDeleted;
		else 
			return "deletion failure";
	}
	@DeleteMapping("/products")
	public String deleteByObject(@RequestBody Product product) {
		int rowsDeleted = productJdbcDao.deleteByObject(product);
		if(rowsDeleted >=1)
			return "No: of rows deleted successfully are :"+rowsDeleted;
		else 
			return "deletion failure";
	}
}


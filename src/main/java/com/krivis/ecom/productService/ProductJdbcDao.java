package com.krivis.ecom.productService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	/*
	public List<Product> findAll(){
		String sql = "select * from product";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Product.class));		
	}
	
	public Product findOne(int id) {
		return (Product) jdbcTemplate.queryForObject("select * from Product where id = ?", new Object[] {id}, new BeanPropertyRowMapper(Product.class));
	}
*/
	public int save(Product product) {
		 return jdbcTemplate.update("insert into Product(title,description) values(?,?)", new Object[] {product.getTitle(),product.getDescription()});
	}

	public int update(Product product) {		
		return jdbcTemplate.update("update Product set title =?, description = ? where id = ?", product.getTitle(),product.getDescription(),product.getId());
	}
/*
	public int update(int id, Product product) {		
		return jdbcTemplate.update("update Product set title =?, description = ? where id = ?", product.getTitle(),product.getDescription(),product.getId());
	}
	*/
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from product where id = ?", id);
	}
	

	public int deleteByObject(Product product) {
		return jdbcTemplate.update("delete from product where id = ?", product.getId());
	}
	
	
	public List<Product> findAll(){
		String sql = "select * from product";
		return jdbcTemplate.query(sql, new ProductRowMapper());		
	}
	
	public Product findOne(int id) {
		return (Product) jdbcTemplate.queryForObject("select * from Product where id = ?", new Object[] {id}, new ProductRowMapper());
	}	
}

package com.restapi.crud.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.crud.jpa.dao.ProductRepository;
import com.restapi.crud.jpa.entities.Product;

@Component
public class ProductConfig 
{
	@Autowired
	private ProductRepository productRepository;
	
	
	// Retrieve all Product Details :
	
	public List<Product> getAllProductDetails()
	{
		List<Product> p1=(List<Product>) productRepository.findAll();
	
		return p1;
	}

	
	// Retrieve Product By Id :
	
	public Product getProductById(int id)
	{
		Product p1=productRepository.getProductById(id);
		
		return p1;
	}
	
	// Delete Product By Id :
	
	public void deteleProductByID(int id)
	{
		this.productRepository.deleteById(id);
	}
	
	// Add Product
	
	public Product addProductDetails(Product product)
	{
		
	    Product p1=this.productRepository.save(product);
	    return p1;
	}
	
	// Update Product Details By using of Id 
	
	
	public void updateDetails(int id, Product product)
	{
		product.setId(id);
		
		productRepository.save(product);
	}
	
	
}

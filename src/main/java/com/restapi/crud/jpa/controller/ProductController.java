package com.restapi.crud.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.crud.jpa.ProductConfig;
import com.restapi.crud.jpa.dao.ProductRepository;
import com.restapi.crud.jpa.entities.Product;

@RestController
public class ProductController 
{

    private final ProductRepository productRepository;
	
	@Autowired
	private ProductConfig productConfig;


    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	
	@GetMapping("/product")
	public List<Product>getProductDetails()
	{
		return productConfig.getAllProductDetails();
	}

	
	@GetMapping("/pro/{id}")
	public Product getProductById(@PathVariable("id") int id)
	{
		Product productById = this.productRepository.getProductById(id);
		return productById;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") int id)
	{
		this.productConfig.deteleProductByID(id);
		
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	
	{
	    Product addProductDetails = this.productConfig.addProductDetails(product);	
	    return addProductDetails;
	    
	}
	
	@PutMapping("/update/{id}")
	public void updateDetails(@PathVariable("id") int id,@RequestBody Product product)
	{
		
		productConfig.updateDetails(id, product);
	}
}

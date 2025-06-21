package com.restapi.crud.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.crud.jpa.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
	
	public Product getProductById(int id);
	

}

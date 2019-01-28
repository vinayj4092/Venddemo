package com.vinay.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.demo.exception.ResourceNotFoundException;
import com.vinay.demo.model.Products;
import com.vinay.demo.repository.Productrepository;


@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private Productrepository productRepository;

	/**
	 * Get all products list.
	 *
	 * @return the list
	 */
	@GetMapping("/products")
	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Create Product .
	 *
	 * @param Producr 
	 * @return the products
	 */
	@PostMapping("/products")
	public Products createProduct(@Valid @RequestBody Products product) {
		return productRepository.save(product);
	}


	/**
	 * Delete Product map.
	 *
	 * @param id of the Product
	 * @return the map
	 * @throws Exception the exception
	 */
	@DeleteMapping("/sales")
	public Map<String, Boolean> getSales(@Valid @RequestBody Products[] product) throws Exception {
		
		
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

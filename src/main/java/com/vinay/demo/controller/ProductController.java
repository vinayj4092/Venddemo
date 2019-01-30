package com.vinay.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.demo.exception.ResourceNotFoundException;
import com.vinay.demo.model.Products;
import com.vinay.demo.model.RequestSalesWrapper;
import com.vinay.demo.model.Sales;
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
	@PostMapping("/sales")
	public RequestSalesWrapper getSales(@Valid @RequestBody Sales[] sale) throws Exception {
		
		RequestSalesWrapper saleResp = new RequestSalesWrapper();
		saleResp.setSales(sale);
		saleResp.setTotalLineItems(sale.length);
		double totalCostVal = 0;
		
		for (Sales sales : sale) {
	
				 Products product =
						 productRepository
			            .findById(Long.parseLong(sales.getProduct_id()))
			            .orElseThrow(() -> new ResourceNotFoundException("Product not found on :: "+ sales.getProduct_id() ));
				 totalCostVal += (sales.getQuantity())*Double.parseDouble(product.getPrice().substring(1));	 
		}
		saleResp.setTotalCostVal(totalCostVal);
		return saleResp;
	}

}

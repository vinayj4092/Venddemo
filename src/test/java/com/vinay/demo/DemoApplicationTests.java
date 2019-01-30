package com.vinay.demo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vinay.demo.model.Products;
import com.vinay.demo.model.RequestSalesWrapper;
import com.vinay.demo.model.Sales;



@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateProduct() {
		Products product = new Products();
		product.setName("Vinay");
		product.setPrice("$60");		

		ResponseEntity<Products> postResponse = restTemplate.postForEntity(getRootUrl() + "/products", product, Products.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testGetAllproducts() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}	
	

	@Test
	public void testCreateSale() {
		
		Sales[] saleArray = new Sales[1];
		Sales sale = new Sales();
		sale.setProduct_id("1");
		sale.setQuantity(2);
		saleArray[0] = sale;
			

		ResponseEntity<RequestSalesWrapper> postResponse = restTemplate.postForEntity(getRootUrl() + "/sales", saleArray, RequestSalesWrapper.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
}


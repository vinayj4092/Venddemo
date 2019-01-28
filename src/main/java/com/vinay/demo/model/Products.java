package com.vinay.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Products {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

		@Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "price", nullable = false)
	    private String price;
	    
	    public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}
		 @Override
		    public String toString() {
		        return "Product{" +
		                "id=" + id +
		                ", name='" + name + '\'' +
		                ", price= '$' + '" + price + '\'' +
		                  '}';
		    }

}

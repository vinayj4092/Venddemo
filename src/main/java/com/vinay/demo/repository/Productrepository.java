package com.vinay.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vinay.demo.model.Products;


@Repository
public interface Productrepository extends JpaRepository<Products, Long> {

}

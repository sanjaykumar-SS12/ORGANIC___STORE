package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CartModel;


public interface CartRepository extends JpaRepository<CartModel, Integer> {

}

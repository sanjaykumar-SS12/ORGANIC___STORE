package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.CustomerSupport;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo crepo;
	
	
	 
	public void addSupport(CustomerSupport e) {
		crepo.save(e);
	}
}

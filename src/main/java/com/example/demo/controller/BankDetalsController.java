package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BankDetailsDao;
import com.example.demo.model.BankDetails;

@RestController
@RequestMapping("/bank")
public class BankDetalsController {

	@Autowired
	private BankDetailsDao bankDetailsDao;

	@GetMapping("/{ifsc}")
	public BankDetails findByIfsc(@PathVariable String ifsc) {
		return bankDetailsDao.findByIfsc(ifsc);
	}

	@GetMapping("/{name}/{city}")
	public List<BankDetails> findByNameAndCity(@PathVariable String name, @PathVariable String city) {
		return bankDetailsDao.findByNameAndCity(name, city);
	}
}

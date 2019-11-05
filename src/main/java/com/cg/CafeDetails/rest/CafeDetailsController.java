package com.cg.CafeDetails.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.CafeDetails.dto.CafeDetails;
import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;
import com.cg.CafeDetails.service.CafeDetailsService;

@RestController
@RequestMapping(value = "/cafedetails")
public class CafeDetailsController {

	@Autowired
	private CafeDetailsService service;
	
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public CafeDetails addCafeDetails(@RequestBody CafeDetails cafedetails) {
		System.out.println(cafedetails);
		return service.addCafeDetails(cafedetails);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public CafeDetails fetchCafeDetailsById(@PathVariable int id) throws CafeDetailsNotFoundException {
		return service.fetchCafeDetailsById(id);
	}
	
	@GetMapping(value = "fetchAll", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetails() {
		return service.fetchAllCafeDetails();
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean removeCafeDetails(@RequestParam int id) throws CafeDetailsNotFoundException {
		return service.removeCafeDetails(id);
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public CafeDetails updateCafeDetails(@RequestBody CafeDetails cafedetails) {
		return service.updateCafeDetails(cafedetails);
	}
}

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

import com.cg.CafeDetails.dto.CafeMenu;
import com.cg.CafeDetails.exception.MenuItemNotFoundException;
import com.cg.CafeDetails.service.CafeDetailsService;

@RestController
@RequestMapping(value = "/menu")
public class CafeMenuController {
	
	@Autowired
	private CafeDetailsService service;
	
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public CafeMenu addMenuItem(@RequestBody CafeMenu cafemenu) {
		return service.addCafeMenu(cafemenu);
	}
	
	@GetMapping(value = "/{itemId}", produces = "application/json")
	public CafeMenu fetchMenuItemByID(@PathVariable int itemId) throws MenuItemNotFoundException {
		return service.fetchCafeMenuById(itemId);
	}
	
	@GetMapping(value = "fetchAll", produces = "application/json")
	public List<CafeMenu> fetchAllMenuItems(){
		return service.fetchAllCafeMenu();
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean deleteMenuItem(@RequestParam int itemId) throws MenuItemNotFoundException {
		return service.removeCafeMenu(itemId);
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public CafeMenu updateMenuItemDetails(@RequestBody CafeMenu cafemenu) {
		return service.updateCafeMenu(cafemenu);
	}

}

package com.cg.CafeDetails.service;

import java.util.List;

import com.cg.CafeDetails.dto.CafeDetails;
import com.cg.CafeDetails.dto.CafeMenu;
import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;
import com.cg.CafeDetails.exception.MenuItemNotFoundException;

public interface CafeDetailsService {

	CafeDetails addCafeDetails(CafeDetails cafedetails);
	
	CafeDetails fetchCafeDetailsById(int cafeId) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchAllCafeDetails();
	
	boolean removeCafeDetails(int cafeId) throws CafeDetailsNotFoundException;
	
	CafeDetails updateCafeDetails(CafeDetails cafedetails);
	
	CafeMenu addCafeMenu(CafeMenu cafemenu);
	
	CafeMenu fetchCafeMenuById(int itemId) throws MenuItemNotFoundException;
	
	List<CafeMenu> fetchAllCafeMenu();
	
	boolean removeCafeMenu(int itemId) throws MenuItemNotFoundException;
	
	CafeMenu updateCafeMenu(CafeMenu cafemenu);
}

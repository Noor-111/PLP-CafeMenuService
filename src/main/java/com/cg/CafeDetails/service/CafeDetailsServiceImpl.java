package com.cg.CafeDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.CafeDetails.dto.CafeDetails;
import com.cg.CafeDetails.dto.CafeMenu;
import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;
import com.cg.CafeDetails.exception.MenuItemNotFoundException;
import com.cg.CafeDetails.repo.CafeDetailsRepo;
import com.cg.CafeDetails.repo.CafeMenuRepo;

@Service
@Transactional(rollbackFor = CafeDetailsNotFoundException.class)
public class CafeDetailsServiceImpl implements CafeDetailsService {

	@Autowired
	private CafeDetailsRepo repo;
	
	@Autowired
	private CafeMenuRepo menurepo;
	
	@Override
	public CafeDetails addCafeDetails(CafeDetails cafedetails) {
//		CafeDetails details = new CafeDetails(110, "Mumbai", 4.4);
//		CafeMenu menu1 = new CafeMenu(5, "Sandwich", "Veg", 65.0);
//		CafeMenu menu2 = new CafeMenu(6, "PavBhaji", "Veg", 115.0);
//
//		details.getMenus().add(menu1);
//		details.getMenus().add(menu2);
//		
//		menu1.getDetails().add(details);
//		menu2.getDetails().add(details);
		return repo.save(cafedetails);
	}

	@Override
	public CafeDetails fetchCafeDetailsById(int cafeId) throws CafeDetailsNotFoundException {
		try {
			return repo.findById(cafeId).get();
		} catch (Exception e) {
			throw new CafeDetailsNotFoundException("No cafe details are available for cafeId: " + cafeId);
		}
	}

	@Override
	public List<CafeDetails> fetchAllCafeDetails() {
		return repo.findAll();
	}

	@Override
	public boolean removeCafeDetails(int cafeId) throws CafeDetailsNotFoundException {
		try {
			repo.deleteById(cafeId);
			return true;
		} catch (Exception e) {
			throw new CafeDetailsNotFoundException("Invalid Cafe Id provided: " + cafeId);
		}
	}

	@Override
	public CafeDetails updateCafeDetails(CafeDetails cafedetails) {
		return repo.save(cafedetails);
	}

	@Override
	public CafeMenu addCafeMenu(CafeMenu cafemenu) {
		return menurepo.save(cafemenu);
	}

	@Override
	public CafeMenu fetchCafeMenuById(int itemId) throws MenuItemNotFoundException {
		try {
			return menurepo.findById(itemId).get();
		} catch (Exception e) {
			throw new MenuItemNotFoundException("No Menu Item for Item Id: "+itemId);
		}
	}

	@Override
	public List<CafeMenu> fetchAllCafeMenu() {
		return menurepo.findAll();
	}

	@Override
	public boolean removeCafeMenu(int itemId) throws MenuItemNotFoundException {
		try {
			menurepo.deleteById(itemId);
			return true;
		} catch (Exception e) {
			throw new MenuItemNotFoundException("Invalid Menu Item ID provided.");
		}
	}

	@Override
	public CafeMenu updateCafeMenu(CafeMenu cafemenu) {
		return menurepo.save(cafemenu);
	}

}

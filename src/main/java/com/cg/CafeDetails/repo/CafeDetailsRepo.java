package com.cg.CafeDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.CafeDetails.dto.CafeDetails;

public interface CafeDetailsRepo extends JpaRepository<CafeDetails, Integer>{

}

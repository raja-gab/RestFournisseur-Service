package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.VenteFlash;

@FeignClient(name = "AdminService")
public interface RestAdminService {
/*	
	@PostMapping("/postventeflash")
	public VenteFlash postVenteFlash(VenteFlash venteFlash) ;
	
	@GetMapping("/getventeflash")
	public VenteFlash getVenteFlash (VenteFlash venteFlash); 
	*/
}

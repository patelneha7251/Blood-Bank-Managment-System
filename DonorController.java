package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.CityRepository;
import com.app.pojos.BloodBank;
import com.app.pojos.City;
import com.app.pojos.Donor;
import com.app.service.IDonorService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/donor")
public class DonorController {
	
	DonorController(){
		System.out.println("DonorController");
	}
	
	
	
	@Autowired
	private IDonorService donorService;
	
	
	@GetMapping("/info")
	public List<Donor> GetAllDonor(){
		System.out.println("GetAllDonor");
		return donorService.getAllDonors();
		
	}
	
	
	
//	@PostMapping("/register")
//	public Donor AddDonor(@RequestBody Donor transientDonor){
//		System.out.println("AddDonor"+transientDonor);
//		
//		 int cityId = 1;
//
//	        // Retrieve the city from the repository based on the cityId
//	        City city = cityRepository.findById(cityId).orElse(null);
//
//	        if (city != null) {
//	            // Associate the retrieved city with the donor
//	            transientDonor.setCity(city);
//
//	            // Save the donor
//	            
//	        }
//	        return donorService.addDonor(transientDonor);
//			
//	}
	@PostMapping("/register")
	public Donor AddDonor(@RequestBody Donor transientDonor){
		System.out.println("AddDonor"+transientDonor);
		
		return donorService.addDonor(transientDonor);
	}
	            
	
	@GetMapping("/{email}")
	public Optional<Donor> getDonorByEmailId(@PathVariable String email){
		System.out.println("getDonorByEmailId"+email);
		return donorService.getDonorByEmailId(email);
	}
	
	@GetMapping("/{email}/{password}")
	public Donor getDonorByEmailAndPass(@PathVariable String email, @PathVariable String password){
		System.out.println("getDonorByEmailAndPass"+email+password);
		return donorService.donorLogin(email,password);
	}
	
	@GetMapping("/verifymobile/{mobile}")
	public boolean getVerifyMobile(@PathVariable String mobile){
		System.out.println("getDonorByMobile"+mobile);
		Donor donor=donorService.getDonorByMobile(mobile);
		System.out.println(donor);
		if(donor != null) {
			return true;
		}
		return true;
	}
	

	@GetMapping("/verifyemail/{email}")
	public boolean getVerifyEmail(@PathVariable String email){
		System.out.println("getBankByEmailId"+email);
		Optional<Donor> donor=donorService.getDonorByEmailId(email);
		System.out.println(donor);
		if(donor.isEmpty()) {
			return true;
		}
		
		return true;
	}
	
}

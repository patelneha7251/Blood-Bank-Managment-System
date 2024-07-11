package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.BloodBank;
import com.app.pojos.BloodStock;
import com.app.service.IBloodBankService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	AdminController(){
		System.out.println("BloodBankController");
	}
	
	@Autowired
	private IBloodBankService bankService;
	
	
	@PostMapping("/registerbank")
	public List<BloodStock> RegisterBloodBank(@RequestBody List<String> emailList){
		System.out.println("Admin AddBloodBank"+emailList);
		 for (String email : emailList) {
	            System.out.println(email);
	        }
		return bankService.RegisterBloodBank(emailList);
	}
	
	@PostMapping("/rejectbank")
	public List<BloodBank> RejectBloodBank(@RequestBody List<String> emailList){
		System.out.println("Admin RejectBloodBank"+emailList);
		 for (String email : emailList) {
	            System.out.println(email);
	        }
		return bankService.RejectBloodBank(emailList);
	}
}

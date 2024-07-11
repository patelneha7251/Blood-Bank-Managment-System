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
import com.app.service.IBloodBankService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bank")
public class BloodBankController {
	
	BloodBankController(){
		System.out.println("BloodBankController");
	}
	
	@Autowired
	private IBloodBankService bankService;
	
	
	@GetMapping("/info")
	public List<BloodBank> GetAllBloodBank(){
		System.out.println("GetAllBloodBank");
		List<BloodBank> list=bankService.getAllBanks();
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/pendinginfo")
	public List<BloodBank> GetAllPendingReqBloodBank(){
		System.out.println("GetAllPendingReqBloodBank");
		List<BloodBank> list=bankService.GetAllPendingReqBloodBank();
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/acceptedinfo")
	public List<BloodBank> GetAllAcceptedBloodBank(){
		System.out.println("GetAllAcceptedBloodBank");
		List<BloodBank> list=bankService.GetAllAcceptedBloodBank();
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/acceptedinfo/city/{cityId}")
	public List<BloodBank> GetAllAcceptedBloodBankOfCity(@PathVariable int cityId){
		System.out.println("GetAllAcceptedBloodBank");
		List<BloodBank> list=bankService.GetAllAcceptedBloodBankOfCity(cityId);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/acceptedinfo/district/{districtId}")
	public List<BloodBank> GetAllAcceptedBloodBankOfDistrict(@PathVariable int districtId){
		System.out.println("GetAllAcceptedBloodBankOfDistrict");
		List<BloodBank> list=bankService.GetAllAcceptedBloodBankOfDistrict(districtId);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/acceptedinfo/state/{stateId}")
	public List<BloodBank> GetAllAcceptedBloodBankOfState(@PathVariable int stateId){
		System.out.println("GetAllAcceptedBloodBankOfState");
		List<BloodBank> list=bankService.GetAllAcceptedBloodBankOfState(stateId);
		System.out.println(list);
		return list;
	}
	
	
	@PostMapping("/register")
	public BloodBank AddBloodBank(@RequestBody BloodBank transientBank){
		System.out.println("AddBloodBank"+transientBank);
		return bankService.addBank(transientBank);
	}
	
	
	
	@GetMapping("verifyemail/{email}")
	public boolean getVerifyEmail(@PathVariable String email){
		System.out.println("getBankByEmailId"+email);
		Optional<BloodBank> bank=bankService.getBankByEmailId(email);
		System.out.println(bank);
		if(bank.isEmpty()) {
			return false;
		}
		return true;
	}
	
	@GetMapping("verifycontact/{contact}")
	public boolean getVerifyMobile(@PathVariable String contact){
		System.out.println("getBankByMobileId"+contact);
		BloodBank bank=bankService.getBankByContactId(contact);
		System.out.println(bank);
		if(bank == null) {
			return false;
		}
		return true;
	}
	
	@GetMapping("verifylicence/{licence}")
	public boolean getVerifyLicence(@PathVariable String licence){
		System.out.println("getBankByLicenceId"+licence);
		BloodBank bank=bankService.getBankByLicenceId(licence);
		System.out.println(bank);
		if(bank == null) {
			return false;
		}
		return true;
	}
	
	
	@PostMapping("/saveall")
	public List<BloodBank> AddAllBloodBank(@RequestBody List<BloodBank> BankList){
		System.out.println("AddAllBloodBank"+BankList);
		return bankService.addAllBank(BankList);
		//return null;
	}
	
	
}

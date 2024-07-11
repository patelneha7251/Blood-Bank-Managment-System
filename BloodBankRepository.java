package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.BloodBank;

public interface BloodBankRepository extends JpaRepository<BloodBank, String>{
	
	@Query(value="select  b from BloodBank b where b.contact=:contact")
	BloodBank getBankByContactId(String contact);
	
	@Query(value="select  b from BloodBank b where b.licence=:licence")
	BloodBank getBankByLicenceId(String licence);
	
	@Query(value="select  b from BloodBank b where b.email=:email")
	BloodBank featchById(String email);

	@Query(value="select  b from BloodBank b where b.status='PENDING'")
	List<BloodBank> GetAllPendingReqBloodBank();
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED'")
	List<BloodBank> GetAllAcceptedBloodBank();
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED' and city.district.state.id=:stateId")
	List<BloodBank> GetAllAcceptedBloodBankOfState(int stateId);
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED' and city.district.id=:districtId ")
	List<BloodBank> GetAllAcceptedBloodBankOfDistrict(int districtId);
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED' and city.id=:cityId")
	List<BloodBank> GetAllAcceptedBloodBankOfCity(int cityId);

	

}

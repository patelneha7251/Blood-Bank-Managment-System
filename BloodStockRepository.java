package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.BloodStock;

public interface BloodStockRepository extends JpaRepository<BloodStock, Integer>{
	
	@Query(value="select  b from BloodStock b where b.bank.email=:email")
	BloodStock getBloodStockByEmail(String email);
	
	@Query(value="select  b from BloodStock b where b.bank.city.id=:cityId")
	List<BloodStock> getAllBloodStockOfCity(int cityId);
	
	@Query(value="select  b from BloodStock b where b.bank.city.district.id=:districtId")
	List<BloodStock> getAllBloodStockOfDistrict(int districtId);

	@Query(value="select  b from BloodStock b where b.bank.city.district.state.id=:stateId")
	List<BloodStock> getAllBloodStockOfState(int stateId);

	

}

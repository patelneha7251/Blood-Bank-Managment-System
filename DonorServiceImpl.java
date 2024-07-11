package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DonorRepository;
import com.app.pojos.Donor;

@Service
@Transactional
public class DonorServiceImpl implements IDonorService {
	
	@Autowired
	private DonorRepository donorRepo;
	
	

	@Override
	public Donor addDonor(Donor transientDonor) {
		// TODO Auto-generated method stub
		return donorRepo.save(transientDonor);
	}
	
	@Override
	public List<Donor> getAllDonors(){
		return donorRepo.findAll();
	}

	@Override
	public Optional<Donor> getDonorByEmailId(String email) {
		// TODO Auto-generated method stub
		return donorRepo.findById(email);
		
	}

	@Override
	public Donor donorLogin(String email, String password) {
		// TODO Auto-generated method stub
		return donorRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public Donor getDonorByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

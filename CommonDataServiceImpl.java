package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CityRepository;
import com.app.dao.DistrictRepository;
import com.app.dao.DonorRepository;
import com.app.dao.StateRepository;
import com.app.dao.UserRepository;
import com.app.pojos.City;
import com.app.pojos.District;
import com.app.pojos.Donor;
import com.app.pojos.State;
import com.app.pojos.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class CommonDataServiceImpl implements ICommonDataService {
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private DistrictRepository districtRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DonorRepository donorRepo;
	
//	@Override
//	public List<State> getAllStates(){
//		
//		return stateRepo.findAll();
//	}
	
//	@Override
//	public List<State> getAllStates(){
//	    System.out.println("Fetching all states...");
//	    List<State> states = stateRepo.findAll();
//	    System.out.println("Fetched states: " + states);
//	    return states;
//	}
	
	@Override
	public String getAllStatesAsJsonString() {
	    System.out.println("Fetching all states...");
	    List<State> states = stateRepo.findAll();
	    System.out.println("Fetched states: " + states);

	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        String json = objectMapper.writeValueAsString(states);
	        return json;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return null; // Handle the error appropriately
	    }
	}



	@Override
	public List<City> getAllCitiesByDistrictId(int districtId) {
		// TODO Auto-generated method stub
		return cityRepo.getAllCitiesByDistrictId(districtId);
	}

	@Override
	public List<District> getAllDistrictsByStateId(int stateId) {
		// TODO Auto-generated method stub
		return districtRepo.getAllDistrictsByStateId(stateId);
	}

	@Override
	public User userLogin(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("userLogin Ser");
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User getUserByEmailId(String email) {
		// TODO Auto-generated method stub
		return userRepo.featchById(email);
}
	
	@Override
	public Donor donorLogin(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("userLogin Ser");
		return donorRepo.findByEmailAndPassword(email, password);
	}
}

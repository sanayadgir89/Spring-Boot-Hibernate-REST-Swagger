package com.sana.fare.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.fare.dao.jpa.IFareRepository;
import com.sana.fare.domain.Fare;


/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class FareService {

	private static final Logger log = LoggerFactory
			.getLogger(FareService.class);

	@Autowired
	private IFareRepository iFareRepository;

	public FareService() {
	}

	public Fare createFare(Fare fare) {
		return iFareRepository.save(fare);
	}

	public Fare getFare(long id) {
		System.out.println("*********"+iFareRepository.findOne(id));
		return iFareRepository.findOne(id);
	}

	public void updateFare(Fare fare) {
		iFareRepository.save(fare);
	}

	public void deleteFare(Long id) {
		iFareRepository.delete(id);
	}

	public List<Fare>  getAllFares() {
		return (List<Fare>) iFareRepository.findAll();
	}

}

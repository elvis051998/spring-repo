package com.abm.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Passenger;
import com.abm.entity.Passenger.Gender;
import com.abm.entity.Passenger.Status;
import com.abm.entity.Pnr;

@RestController
public class PnrController {

	@RequestMapping("/pnr-status")
	public Pnr checkPnrStatus(@RequestParam("pnrNo") int pnrNo) {
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(121619);
		pnr.setTravelDate(LocalDate.of(2022, 11, 05));
		
		List<Passenger> passenger = new ArrayList<>();
		
		Passenger p1 = new Passenger();
		
		p1.setName("Elvis");
		p1.setGender(Gender.MALE);
		p1.setStatus(Status.COMFIRMED);
		
		Passenger p2 = new Passenger();
		
		p2.setName("Saurabh");
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.RAC);
		
		passenger.add(p1);
		passenger.add(p2);
		
		pnr.setPassenger(passenger);
		
		return pnr;
		
		
	}
}

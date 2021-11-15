package com.psl.training.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.entity.AppointmentCalendar;
import com.psl.training.entity.AppointmentEntry;
import com.psl.training.service.AppointmentEntryService;

@RestController
public class BookController {
	
	@Autowired
	AppointmentEntryService serviceAE;
	
	
//	@GetMapping("/book/{text}")
//	public List<AppointmentCalendar> getAllAppointment(@RequestBody String type , @PathVariable("text") String text){
//		
//		return serviceAE.getAllAppointment(text,type);
//	}
	
	
	
//	
//	@GetMapping("/book/{acid}")
//	public List<Integer> getAppointmentByNameDate(@RequestBody LocalDate dt , @PathVariable("acid") long acid){
//		System.out.println(dt);
//		return serviceAE.getAppointmentByNameDate(dt,acid);
//	}
//	
	
	
	@GetMapping("/book/{acid}")
	public List<Integer> getAllUnbookedAppointment(@RequestBody String dt , @PathVariable("acid") long acid){
		System.out.println(dt);
		return serviceAE.getAllUnbookedAppointment(dt,acid);
	}
	
	
	
	@PostMapping("/book/{acid}/createaeform")
	public AppointmentEntry createAppointment(@RequestBody AppointmentEntry ae , @PathVariable("acid") long acid){
		return serviceAE.insertAppointmentEntry(ae);
	}
	
	
	

}

package com.psl.training.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.entity.AppointmentCalendar;
import com.psl.training.entity.AppointmentEntry;
import com.psl.training.entity.User;
import com.psl.training.service.AppointmentCalendarService;
import com.psl.training.service.AppointmentEntryService;
import com.psl.training.service.UserService;

@RestController
public class AppointmentCalendarController {

	@Autowired
	AppointmentCalendarService serviceAC;
	
	@Autowired
	AppointmentEntryService serviceAE;
	
	@Autowired
	UserService serviceU;
	
	@PostMapping("/ac/{userID}/createacform")
	public String insertAppointmentCalendar(@RequestBody AppointmentCalendar appointmentCalendar, @PathVariable("userID") long userID)
	{
		User owner = serviceU.findByUserID(userID);
		appointmentCalendar.setOwner(owner);
		System.out.println(appointmentCalendar.getOwner().getUserID());
		serviceAC.insertAppointmentCalendar(appointmentCalendar);
		return "Appoinment Calendar Inserted";
	}
	
	@GetMapping("/ac")
	public List<AppointmentCalendar> getAppointmentCalendarsByUserID(@RequestBody Map<String, Long> payload)
	{
		
		System.out.println(payload.get("userID"));
		return serviceAC.getAppointmentCalendarByUserID(payload.get("userID"));

	}
	
//	@GetMapping("/ac")
//	public String getAppointmentCalendarsByUserID(@RequestBody String payload)
//	{
//		
//		//System.out.println(payload.get("userID"));
//		return payload;
//
//	}	
	
	
	
}

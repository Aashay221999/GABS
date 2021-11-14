package com.psl.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AppointmentEntryController {

	@Autowired
	AppointmentEntryService serviceAE;
	
	@Autowired
	AppointmentCalendarService serviceAC;
	
	@Autowired
	UserService serviceU;
	
	@PostMapping("/book/{appointeeID}/{acID}/createaeform")
	public String insertAppointmentEntry(@RequestBody AppointmentEntry appointmentEntry, @PathVariable("acID") long acID, @PathVariable("appointeeID") long appointeeID)
	{
		AppointmentCalendar appointmentCalendar = serviceAC.getAppointmentCalendarById(acID);
		appointmentEntry.setAppointmentCalendar(appointmentCalendar);
		
		User owner = serviceU.findByUserID(appointmentCalendar.getOwner().getUserID());
		User appointee = serviceU.findByUserID(appointeeID);
		
		appointmentEntry.setOwner(owner);
		appointmentEntry.setAppointee(appointee);
		
		
		serviceAE.insertAppointmentEntry(appointmentEntry);
		return "Appointment Entry Inserted";
	}
	
	
}

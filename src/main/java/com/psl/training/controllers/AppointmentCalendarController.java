package com.psl.training.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/ac/{userID}")
	public List<AppointmentCalendar> getAppointmentCalendarsByUserID(@PathVariable("userID") long userID)
	{

		User owner = serviceU.findByUserID(userID);
		
		return serviceAC.getAppointmentCalendarByUserID(owner.getUserID());

	}
	
	@DeleteMapping("ac/{acid}")
	public String deleteAppointmentCalendar(@PathVariable("acID") long acID)
	{
		serviceAC.deleteAppointmentCalendarById(acID);
		return "Delete Appointment Calendar";
	}
	
	@GetMapping("ac/{acid}/approved")
	public List<AppointmentEntry> getApprovedAppointmentEntitiesByAcID(@PathVariable("acID") long acID)
	{
		return serviceAE.getSpecificAppointmentEntry(acID, true);
	}
	
	@GetMapping("ac/{acID}/notapproved")
	public List<AppointmentEntry> getNotApprovedAppointmentEntitiesByAcID(@PathVariable("acID") long acID)
	{
		return serviceAE.getSpecificAppointmentEntry(acID, false);
	}

	@PutMapping("ac/{acID}/approve/{aeID}")
	public String approveAppointmentEntryByAeID(@PathVariable("aeID") long aeID)
	{
		AppointmentEntry appointmentEntry = serviceAE.getAppointmentEntryById(aeID);
		appointmentEntry.setIsApproved(true);
		serviceAE.approveAppointmentEntry(appointmentEntry);
		return "Appointment is Approved";
	}
	
	@DeleteMapping("ac/{acID}/reject/{aeID}")
	public String rejectAppointmentEntryByAeID(@PathVariable("aeID") long aeID)
	{
		serviceAE.deleteAppointmentEntryById(aeID);
		return "Appointment Entry is Deleted";
	}
	
}

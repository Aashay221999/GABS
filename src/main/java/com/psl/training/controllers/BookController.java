package com.psl.training.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class BookController {
	
	@Autowired
	AppointmentEntryService serviceAE;
	
	@Autowired
	AppointmentCalendarService serviceAC;
	
	@Autowired
	UserService serviceU;

	
	
	@GetMapping("/book/{acid}/{date}")
	public List<Integer> getAllUnbookedAppointment(@PathVariable("acid") long acid,@PathVariable("date") String stringDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(stringDate, formatter);
		return serviceAE.getAllUnbookedAppointment(localDate, acid);
	}
	
	
	
	@PostMapping("/book/{userID}/{acID}}/createaeform")
	public AppointmentEntry createAppointment(@RequestBody AppointmentEntry appointmentEntry , @PathVariable("acID") long acID, @PathVariable("userID") long userID){
		AppointmentCalendar appointmentCalendar = serviceAC.getAppointmentCalendarById(acID);
		User appointee = serviceU.findByUserID(userID);
		appointmentEntry.setAppointee(appointee);
		appointmentEntry.setOwner(appointmentCalendar.getOwner());
		
		
		return serviceAE.insertAppointmentEntry(appointmentEntry);
	}
	
	@GetMapping("/book/{searchText}/{searchCriteria}")
	public List<AppointmentCalendar> getAppointmentCalendarsBySearch(@PathVariable("searchText") String searchText,@PathVariable("searchCriteria") String searchCriteria )
	{
		//searchCriteria can by Location, Type, Owner
		if (searchCriteria == "Location")
		{
			return serviceAC.getAppointmentCalendarByLocation(searchText);
		}
		else if (searchCriteria == "Type")
		{
			return serviceAC.getAppointmentCalendarByType(searchText);
		}
		else 
		{
			//searchCriteria == User
			return serviceAC.getAppointmentCalendarByUserName(searchText);
		}
	}
}

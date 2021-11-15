package com.psl.training.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.psl.training.entity.AppointmentEntry;
import com.psl.training.service.AppointmentEntryService;

@RestController
public class HomeController {
	
	
	@Autowired
	AppointmentEntryService serviceAE;
	
	@GetMapping("/ome")
	public String Home() {
		return "hello world";
	}
	
	
//	
//	@GetMapping("/home/{aeid}")
//	public AppointmentEntry getAppointmentEntryById(@RequestBody long aeid ){
//		return serviceAE.getAppointmentEntryById(aeid);
//	}
//}
	
	
	
	@GetMapping("/home/{aeid}")
	public AppointmentEntry getAppointmentEntryById(@PathVariable("aeid") long aeid){
		return serviceAE.getAppointmentEntryById(aeid);
	}
}
	

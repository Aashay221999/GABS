package com.psl.training.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psl.training.entity.AppointmentCalendar;
import com.psl.training.entity.User;

public interface AppointmentCalendarRepository  extends JpaRepository<AppointmentCalendar, Long> {


	
	public List<AppointmentCalendar> findByType(String type);

	public List<AppointmentCalendar> findByLocation(String location);
	
	public List<AppointmentCalendar> findByOwner(User owner);
	
	
	
}

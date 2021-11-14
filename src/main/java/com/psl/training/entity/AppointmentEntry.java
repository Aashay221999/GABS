package com.psl.training.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;



@Entity
@Table(name = "AppointmentEntries", uniqueConstraints = {@UniqueConstraint(columnNames = {"aeID"})})
public class AppointmentEntry {
	
	@Id
	@Column(nullable = false)
	private long aeID;
	

	@ManyToOne
	@JoinColumn(name="acID", nullable=false)
	private AppointmentCalendar appointmentCalendar;
	
	@ManyToOne
	@JoinColumn(name="owner_id", nullable=false, insertable=true, updatable=false)
	private User owner;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private Boolean isApproved;
	
	@Column(nullable = false)
	private int timeSlot;
	
	@ManyToOne
	@JoinColumn(name="apointee_id", nullable=false)
	private User appointee;
	
	@Column(nullable = false)
	private String description;

	public AppointmentEntry()
	{
		
	}
	
	public AppointmentEntry(long aeID, AppointmentCalendar appointmentCalendar, User owner, LocalDate date,
			Boolean isApproved, int timeSlot, User appointee, String description) {
		super();
		this.aeID = aeID;
		this.appointmentCalendar = appointmentCalendar;
		this.owner = owner;
		this.date = date;
		this.isApproved = isApproved;
		this.timeSlot = timeSlot;
		this.appointee = appointee;
		this.description = description;
	}

	public long getAeID() {
		return aeID;
	}

	public void setAeID(long aeID) {
		this.aeID = aeID;
	}

	public AppointmentCalendar getAppointmentCalendar() {
		return appointmentCalendar;
	}

	public void setAppointmentCalendar(AppointmentCalendar appointmentCalendar) {
		this.appointmentCalendar = appointmentCalendar;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public User getAppointee() {
		return appointee;
	}

	public void setAppointee(User appointee) {
		this.appointee = appointee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}

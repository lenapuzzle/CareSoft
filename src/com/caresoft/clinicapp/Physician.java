package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	// Constructor with ID
	public Physician(Integer id) {
		super(id);
	}
  
    private ArrayList<String> patientNotes;
    
    
    // Implementing Interface
    public boolean assignPin(int pin) {
    	int len = String.valueOf(pin).length();
    	if(len == 4) {
    		return true;
    	} 
    	else {
    		return false;
    	}
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(this.id == confirmedAuthID) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    // Inside class
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    // Getters and Setters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}

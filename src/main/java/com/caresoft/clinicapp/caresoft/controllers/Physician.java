package com.caresoft.clinicapp.caresoft.controllers;

import java.util.*;
import com.caresoft.clinicapp.caresoft.interfaces.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser{

    private ArrayList<String> patientNotes;

    public Physician(int id) {
        super(id);
    }

    @Override
    public boolean assignPin(int pin) {
        if (pin > 999 && pin < 10000 ){
            this.pin = pin;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        
        if(confirmedAuthID == this.id){
            return true;
        }
        return false;
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}

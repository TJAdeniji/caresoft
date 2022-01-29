package com.caresoft.clinicapp.caresoft.controllers;

import java.util.*;
import com.caresoft.clinicapp.caresoft.interfaces.HIPAACompliantAdmin;
import com.caresoft.clinicapp.caresoft.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
    
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(int id, String role) {
        super(id);
        this.role = role;
        this.securityIncidents = new ArrayList<String>();
    }
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
        if (pin > 99999 && pin < 1000000){
            this.pin = pin;
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if(confirmedAuthID != this.id){
            this.authIncident();
            return false;
        }
        return true; 
    }
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
        for (int i = 0; i < securityIncidents.size(); i++){
            System.out.println(securityIncidents.get(i));
        }
        return this.securityIncidents;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        this.securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        System.out.println(report);
        this.securityIncidents.add(report);
    }
    // TO DO: Setters & Getters
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }
    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }

    
    
}

/*
 * Author: Jordan Mitchell
 * 10/3/2024
 * Course: CS-320
 */
package Appointment;

import java.util.Date;

public class Appointment {
    
    private final String uniqueID;  //Cannot be changed
    private Date apptDate;
    private String description;

    //Validates appointment ID
    private final boolean validateID(String uniqueID) {
        return uniqueID != null && uniqueID.length() <= 10;
    }

    //Validates appointment date (must be in the future)
    private final boolean validateAppointmentDate(Date apptDate) {
        return apptDate != null && !apptDate.before(new Date()); //Allows today or future dates
    }


    //Validates description
    private final boolean validateDescription(String description) {
        return description != null && description.length() <= 50 && !description.isEmpty();
    }

    //Constructor
    public Appointment(String uniqueID, Date apptDate, String description) {
        if (!this.validateID(uniqueID)) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (!this.validateAppointmentDate(apptDate)) {
            throw new IllegalArgumentException("Invalid appointment date");
        }

        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        //Since uniqueID is final, can only be set once
        this.uniqueID = uniqueID;
        this.apptDate = apptDate;
        this.description = description;
    }

    //Getter for uniqueID (no setter, since it cannot be updated)
    public String getUniqueID() {
        return uniqueID;
    }

    //Getter and Setter for apptDate
    public Date getApptDate() {
        return apptDate;
    }

    public void setApptDate(Date apptDate) {
        if (!this.validateAppointmentDate(apptDate)) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.apptDate = apptDate;
    }

    //Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}


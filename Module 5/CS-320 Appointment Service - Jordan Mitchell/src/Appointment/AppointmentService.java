/*
 * Author: Jordan Mitchell
 * 10/3/2024
 * Course: CS-320
 */
package Appointment;

import java.util.HashMap;
import java.util.Date;
import Appointment.Appointment;


public class AppointmentService {

    //Store appointments using HashMap with appointment ID as key
    private HashMap<String, Appointment> appointments = new HashMap<>();
    private int currentIDNum = 0;  //Mock GUID for unique IDs

    //Generate unique appointment ID
    private String generateUniqueID() {
        return Integer.toString(currentIDNum++);
    }

    //Add a new appointment
    public void addAppointment(Date apptDate, String description) {
        String appointmentID = generateUniqueID();  //Create unique ID
        Appointment newAppointment = new Appointment(appointmentID, apptDate, description);  //Create new appointment
        appointments.put(appointmentID, newAppointment);  //Store appointment in HashMap
    }

    //Delete appointment by ID
    public void deleteAppointmentById(String appointmentID) {
        if (appointments.containsKey(appointmentID)) {
            appointments.remove(appointmentID);  //Remove appointment if it exists
        } else {
            throw new IllegalArgumentException("Appointment with ID " + appointmentID + " does not exist.");
        }
    }

    //Get appointment by ID
    public Appointment getAppointmentById(String appointmentID) {
        if (appointments.containsKey(appointmentID)) {
            return appointments.get(appointmentID);  //Return appointment if found
        } else {
            throw new IllegalArgumentException("Appointment with ID " + appointmentID + " does not exist.");
        }
    }
    
    //Check if an appointment exists by ID
    public boolean appointmentExists(String appointmentID) {
        return appointments.containsKey(appointmentID);
    }

    //Clear all appointments
    public void clearAppointments() {
        appointments.clear();
    }

    //Get the size of the appointment list (for testing)
    public int getAppointmentListSize() {
        return appointments.size();
    }
}

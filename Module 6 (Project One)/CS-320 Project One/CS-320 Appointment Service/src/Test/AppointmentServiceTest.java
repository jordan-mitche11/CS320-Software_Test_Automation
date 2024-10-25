/*
 * Author: Jordan Mitchell
 * 10/3/2024
 * Course: CS-320
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

import java.util.Calendar;
import java.util.Date;

class AppointmentServiceTest {

    private AppointmentService appointmentService;

    //Setup AppointmentService before each test
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    //Test adding valid appointment
    @DisplayName("Test adding valid appointment")
    @Test
    void testAddAppointment() {
        String description = "Doctor's appointment";
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2026, Calendar.MARCH, 15); //Future date
        Date futureDate = calendar.getTime();
        
        assertEquals(0, appointmentService.getAppointmentListSize());

        appointmentService.addAppointment(futureDate, description);

        Appointment addedAppointment = appointmentService.getAppointmentById("0");
        
        assertNotNull(addedAppointment);  //Verify appointment is added
        assertEquals(futureDate, addedAppointment.getApptDate());
        assertEquals(description, addedAppointment.getDescription());
    }

    //Test deleting appointment
    @DisplayName("Test deleting appointment by valid ID")
    @Test
    void testDeleteAppointmentById() {
        String description = "Dentist appointment";
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2026, Calendar.JUNE, 10); //Future date
        Date futureDate = calendar.getTime();

        appointmentService.addAppointment(futureDate, description);  //Add appointment ID 0
        appointmentService.addAppointment(futureDate, description);  //Add appointment ID 1
        appointmentService.addAppointment(futureDate, description);  //Add appointment ID 2

        assertEquals(3, appointmentService.getAppointmentListSize());

        appointmentService.deleteAppointmentById("1");

        assertEquals(2, appointmentService.getAppointmentListSize());
        assertFalse(appointmentService.appointmentExists("1"), "Appointment ID '1' should be deleted");

        //Ensure accessing deleted appointment throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.getAppointmentById("1");
        });
    }

    //Test deleting non-existent appointment
    @DisplayName("Test deleting non-existent appointment")
    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointmentById("999"); //Non-existent ID
        });
    }

    //Test retrieving appointment by valid ID
    @DisplayName("Test retrieving appointment by valid ID")
    @Test
    void testGetAppointmentById() {
        String description = "Meeting with client";
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2026, Calendar.AUGUST, 22); //Future date
        Date futureDate = calendar.getTime();

        appointmentService.addAppointment(futureDate, description);

        Appointment retrievedAppointment = appointmentService.getAppointmentById("0");

        assertNotNull(retrievedAppointment);  //Verify appointment exists
        assertEquals(futureDate, retrievedAppointment.getApptDate());
        assertEquals(description, retrievedAppointment.getDescription());
    }

    //Test retrieving appointment with non-existent ID
    @DisplayName("Test retrieving appointment with non-existent ID")
    @Test
    void testGetNonExistentAppointmentById() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.getAppointmentById("999"); //Non-existent ID
        });
    }
}


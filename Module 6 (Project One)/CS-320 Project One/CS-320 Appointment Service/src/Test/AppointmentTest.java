/*
 * Author: Jordan Mitchell
 * 10/3/2024
 * Course: CS-320
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

import java.util.Calendar;
import java.util.Date;

class AppointmentTest {

	// Test valid constructor
	@DisplayName("Test valid constructor")
	@Test
	void testValidConstructor() {
		String id = "1";
		String description = "Doctor's appointment";

		Calendar calendar = Calendar.getInstance();
		calendar.set(2026, Calendar.MARCH, 15); //Future date
		Date futureDate = calendar.getTime();

		//Create valid Appointment obj
		Appointment appointment = new Appointment(id, futureDate, description);

		//Assert values assigned properly
		assertEquals(id, appointment.getUniqueID());
		assertEquals(futureDate, appointment.getApptDate());
		assertEquals(description, appointment.getDescription());
	}

	//Test constructor with invalid past date
	@DisplayName("Test Appointment constructor with past date")
	@Test
	void testInvalidPastDateConstructor() {
		String id = "1";
		String description = "Doctor's appointment";

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, Calendar.JANUARY, 1); // Past date
		Date pastDate = calendar.getTime();

		// Ensure constructor throws IllegalArgumentException for past date
		assertThrows(IllegalArgumentException.class, () -> new Appointment(id, pastDate, description));
	}

	// Test constructor with invalid description (too long)
	@DisplayName("Test Appointment constructor with invalid long description")
	@Test
	void testInvalidLongDescriptionConstructor() {
		String id = "1";
		String longDescription = "This description is far too long and exceeds the 50 character limit imposed on descriptions.";

		Calendar calendar = Calendar.getInstance();
		calendar.set(2026, Calendar.MARCH, 15); // Future date
		Date futureDate = calendar.getTime();

		// Ensure constructor throws IllegalArgumentException for long description
		assertThrows(IllegalArgumentException.class, () -> new Appointment(id, futureDate, longDescription));
	}

	// Test updating appointment date with valid future date
	@DisplayName("Test valid setApptDate")
	@Test
	void testSetApptDate() {
		String id = "1";
		String description = "Doctor's appointment";

		Calendar calendar = Calendar.getInstance();
		calendar.set(2026, Calendar.MARCH, 15); // Future date
		Date futureDate = calendar.getTime();

		// Create valid Appointment obj
		Appointment appointment = new Appointment(id, futureDate, description);

		// Set new valid future date
		calendar.set(2026, Calendar.MAY, 10); // Future date
		Date newDate = calendar.getTime();
		appointment.setApptDate(newDate); // Use setApptDate

		// Ensure date was updated
		assertEquals(newDate, appointment.getApptDate());
	}

	//Test setting appointment date with past date
	@DisplayName("Test invalid setApptDate with past date")
	@Test
	void testSetPastDate() {
	    String id = "1";
	    String description = "Doctor's appointment";

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(2026, Calendar.MARCH, 15); //Valid future date
	    Date futureDate = calendar.getTime();

	    //Create valid Appointment obj
	    Appointment appointment = new Appointment(id, futureDate, description);

	    //Attempt to set a past date
	    calendar.set(2020, Calendar.JANUARY, 1); //Past Date
	    Date pastDate = calendar.getTime();

	    //Ensure setApptDate throws IllegalArgumentException for past date
	    assertThrows(IllegalArgumentException.class, () -> {
	        appointment.setApptDate(pastDate);
	    });
	}


	// Test updating description with valid input
	@DisplayName("Test valid setDescription")
	@Test
	void testSetDescription() {
		String id = "1";
		String description = "Doctor's appointment";

		Calendar calendar = Calendar.getInstance();
		calendar.set(2026, Calendar.MARCH, 15); // Future date
		Date futureDate = calendar.getTime();

		// Create valid Appointment obj
		Appointment appointment = new Appointment(id, futureDate, description);

		// Update description
		String newDescription = "Dentist's appointment";
		appointment.setDescription(newDescription);

		// Ensure description was updated
		assertEquals(newDescription, appointment.getDescription());
	}

	// Test setting invalid description (too long)
	@DisplayName("Test invalid setDescription with long description")
	@Test
	void testSetLongDescription() {
		String id = "1";
		String description = "Doctor's appointment";

		Calendar calendar = Calendar.getInstance();
		calendar.set(2026, Calendar.MARCH, 15); // Future date
		Date futureDate = calendar.getTime();

		// Create valid Appointment obj
		Appointment appointment = new Appointment(id, futureDate, description);

		// Attempt to set long description
		String longDescription = "The chosen description is far too long and far exceeds the 50 character limit.";

		// Ensure setDescription throws IllegalArgumentException for long description
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription(longDescription);
		});
	}
}

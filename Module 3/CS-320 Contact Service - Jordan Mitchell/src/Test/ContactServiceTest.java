/*
 * Author: Jordan Mitchell
 * Date: 9/20/2024
 * Course: CS-320
 * This is to test ContactService
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Contact.Contact;
import Contact.ContactService;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    //Test adding contact and verifying it's added correctly
    @Test
    @DisplayName("Test adding a contact")
    public void testAddContact() {
        contactService.addContact("Jack", "Sparrow", "1234567890", "123 Black Pearl Rd");
        Contact contact = contactService.getContact("0"); //0 is first ID generated
        assertNotNull(contact, "Contact should not be null");
        assertEquals("Jack", contact.getFirstName(), "First name should be Jack");
        assertEquals("Sparrow", contact.getLastName(), "Last name should be Sparrow");
        assertEquals("1234567890", contact.getPhoneNumber(), "Phone number should be 1234567890");
        assertEquals("123 Black Pearl Rd", contact.getAddress(), "Address should be 123 Black Pearl Rd");
    }

    //Test updating first name
    @Test
    @DisplayName("Test updating first name")
    public void testUpdateFirstName() {
        contactService.addContact("Jack", "Sparrow", "1234567890", "123 Black Pearl Rd");
        contactService.updateFirstName("Hermione", "0"); //Update first name of contactID 0
        Contact updatedContact = contactService.getContact("0");
        assertEquals("Hermione", updatedContact.getFirstName(), "First name should be updated to Hermione");
    }

    //Test updating last name
    @Test
    @DisplayName("Test updating last name")
    public void testUpdateLastName() {
        contactService.addContact("Jack", "Sparrow", "1234567890", "123 Black Pearl Rd");
        contactService.updateLastName("Granger", "0"); //Update last name of contactID 0
        Contact updatedContact = contactService.getContact("0");
        assertEquals("Granger", updatedContact.getLastName(), "Last name should be updated to Granger");
    }

    //Test updating phone number
    @Test
    @DisplayName("Test updating phone number")
    public void testUpdatePhoneNumber() {
        contactService.addContact("Jack", "Sparrow", "1234567890", "123 Black Pearl Rd");
        contactService.updateNumber("0987654321", "0"); //Update phone number of the contactID 0
        Contact updatedContact = contactService.getContact("0");
        assertEquals("0987654321", updatedContact.getPhoneNumber(), "Phone number should be updated to 0987654321");
    }

    //Test updating address
    @Test
    @DisplayName("Test updating address")
    public void testUpdateAddress() {
        contactService.addContact("Jack", "Sparrow", "1234567890", "123 Black Pearl Rd");
        contactService.updateAddress("456 Muggle Way", "0"); //Update address of contactID 0
        Contact updatedContact = contactService.getContact("0");
        assertEquals("456 Muggle Way", updatedContact.getAddress(), "Address should be updated to 456 Muggle Way");
    }

    //Test deleting contact
    @Test
    @DisplayName("Test deleting a contact")
    public void testDeleteContact() {
        contactService.addContact("Jack", "Sparrow", "1234567890", "123 Black Pearl Rd");
        contactService.deleteContact("0"); //Delete contactID 0
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("0"); //Try to get deleted contact
        }, "Contact should be deleted and not found");
    }

    //Test retrieving non-existent contact
    @Test
    @DisplayName("Test retrieving non-existent contact")
    public void testGetNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("999"); //Try to get contact with non-existent ID
        }, "Contact with non-existent ID should throw an exception");
    }
}


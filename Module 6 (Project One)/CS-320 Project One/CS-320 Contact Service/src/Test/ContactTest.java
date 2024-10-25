/*Author: Jordan Mitchell
 * Date: 9/18/2024
 * Course: CS-320
 * This is the test for the contact class */
package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {

    
    //Test for good constructor	
    @DisplayName("Test valid Constructor")
    @Test
    public void testGoodConstructor() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        
		assertEquals(contactId, testContact.getContactID());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phoneNumber, testContact.getPhoneNumber());
		assertEquals(address, testContact.getAddress());
	}
	
	//Test constructor with invalid phone number length
	@DisplayName("Test invalid Constructor")
	@Test
	public void testBadConstructor() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1";  // Invalid phone number
        String address = "123 Force St";       
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactId, firstName, lastName, phoneNumber, address);
        });
	}
	
	//Test setFirstName with good input 
	@DisplayName("Test valid setFirstName")
	@Test
	public void testGoodSetFirst() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setFirstName("Test");        
        assertEquals("Test", testContact.getFirstName());
	}
	
	//Test setFirstName with null string. throw error
	@DisplayName("Test invalid null setFirstName")
	@Test
	public void testBadSetFirst() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
	}
	

	//Test setFirstName with length that is too long. throw exception
	@DisplayName("Test invalid length setFirstName")
	@Test
	public void testLongSetFirst() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("IamFarTooLongOfAFirstName");
        });
	}
	
	//Test getID by using a good constructor. ensure the correct ID is returned
	@DisplayName("Test getID")
	@Test
	public void testGetID() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertEquals(contactId, testContact.getContactID());
	}
	
	//Test setLastName with null string. throw error
	@DisplayName("Test invalid null setLastName")
	@Test
	public void testBadSetLast() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName(null);
        });
	}
	
	//Test setLastName with length that is too long. throw exception
	@DisplayName("Test invalid length setLastName")
	@Test
	public void testLongSetLast() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("IamFarTooLongOfALastName");
        });
	}
	
	//Test setLastName with valid input 
	@DisplayName("Test valid setLastName")
	@Test
	public void testGoodsetLast() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setLastName("Test");        
        assertEquals("Test", testContact.getLastName());
	}
	
	//Test setPhoneNumber with null string. throw error
	@DisplayName("Test invalid null setPhoneNumber")
	@Test
	public void testBadSetPhone() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber(null);
        });
        
	}
	
	//Test the setPhone length != 10. throw exception
	@DisplayName("Test invalid length setPhoneNumber")
	@Test
	public void testWrongLengthPhone() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("123456789101112131415");
        });
	}
	
	//Test setPhone with length of 10
	@DisplayName("Test valid length setPhoneNumber")
	@Test
	public void testGoodPhone() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setPhoneNumber("1987654321");        
        assertEquals("1987654321", testContact.getPhoneNumber());

	}
	
	//Test setAddress with null string. throw error
	@DisplayName("Test invalid null setAddress")
	@Test
	public void testNullSetAddress() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
        
	}
	
	//Test setAddress with length > 30. throw exception
	@DisplayName("Test invalid length setAddress")
	@Test
	public void testWrongLengthAddress() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("123456789 Address Absolutely Incredibly Far too Long Street");
        });
	}
	
	//Test setAddress with valid input
	@DisplayName("Test valid length setAddress")
	@Test
	public void testGoodAddress() {
        String contactId = "05";
      	String firstName = "Luke";
        String lastName = "Skywalker";
        String phoneNumber = "1234567891";
        String address = "123 Force St";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setAddress("987 Good Address");        
        assertEquals("987 Good Address", testContact.getAddress());

	}
}


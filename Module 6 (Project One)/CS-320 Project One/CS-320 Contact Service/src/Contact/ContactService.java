/*
Author: Jordan Mitchell
Date: 9/19/2024
Course: CS-320 
This is the contact service that maintains contacts with capability to add, change, or delete contact info*/
package Contact;

import java.util.ArrayList;

public class ContactService {
    //ArrayList to hold list of contacts
    public ArrayList<Contact> contactList = new ArrayList<>();
    private int currentIDNum = 0; //Unique identifier for contact ID

    //Display the full list of contacts to the console for error checking.
    public void displayContactList() {
        for (Contact contact : contactList) {
            System.out.println("\t Contact ID: " + contact.getContactID());
            System.out.println("\t First Name: " + contact.getFirstName());
            System.out.println("\t Last Name: " + contact.getLastName());
            System.out.println("\t Phone Number: " + contact.getPhoneNumber());
            System.out.println("\t Address: " + contact.getAddress() + "\n");
        }
    }

    //Add new contact using Contact constructor and assign new contact to list
    public void addContact(String firstName, String lastName, String number, String address) {
        String contactID = Integer.toString(currentIDNum++);
        Contact contact = new Contact(contactID, firstName, lastName, number, address);
        contactList.add(contact);
    }

    //Use contactID to return contact object or throw exception if not found
    public Contact getContact(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact with ID: " + contactID + " not found.");
    }

    //Delete contact using contactID.
    public void deleteContact(String contactID) {
        boolean found = false;
        for (int counter = 0; counter < contactList.size(); counter++) {
            if (contactList.get(counter).getContactID().equals(contactID)) {
                contactList.remove(counter);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    //Update first name.
    public void updateFirstName(String updatedString, String contactID) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setFirstName(updatedString);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    //Update last name.
    public void updateLastName(String updatedString, String contactID) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setLastName(updatedString);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    //Update phone number.
    public void updateNumber(String updatedString, String contactID) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setPhoneNumber(updatedString); //Ensure consistent name
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    //Update address.
    public void updateAddress(String updatedString, String contactID) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setAddress(updatedString);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }
}

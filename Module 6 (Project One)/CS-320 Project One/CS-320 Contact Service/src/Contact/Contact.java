/*Author: Jordan Mitchell
 * Date: 9/18/2024
 * Course: CS-320
 */
package Contact;

public class Contact {

    private final String contactID; //Cannot be updated!!
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    /**
     * Validation for contactID
     * @param contactID
     * @return boolean
     */
    private boolean validateID(String contactID) {
        return contactID != null && contactID.length() <= 10;
    }

    /**
     * Validation for last name
     * @param lastName
     * @return boolean
     */
    private boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() <= 10;
    }

    /**
     * Validation for first name
     * @param firstName
     * @return boolean
     */
    private boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() <= 10;
    }

    /**
     * Validation for phone number
     * @param phoneNumber
     * @return boolean
     */
    private boolean validatePhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            return false;
        }
        
        // Check if each character is a digit
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Validation for address
     * @param address
     * @return boolean
     */
    private boolean validateAddress(String address) {
        return address != null && address.length() <= 30;
    }

    //Constructor to initialize all fields and validates input
    public Contact(String contactID,
                   String firstName,
                   String lastName,
                   String phoneNumber,
                   String address) {
    	//Validation for contactID, if invalid throw exception
        if (!this.validateID(contactID)) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        //Validation for firstName, if invalid throw exception
        if (!this.validateFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        //Validation for lastName, if invalid throw exception
        if (!this.validateLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        //Validation for phoneNumber, if invalid throw exception
        if (!this.validatePhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        //Validation for address, if invalid throw exception
        if (!this.validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        //If all validations passed, assign values
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    //Getter for contactID, cannot be updated
    public String getContactID() {
        return contactID;
    }
    //Getter for firstName
    public String getFirstName() {
        return firstName;
    }
    //Setter for firstName with validation
    public void setFirstName(String firstName) {
        if (!this.validateFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName; //Set valid firstName
    }
    //Getter for lastName
    public String getLastName() {
        return lastName;
    }
    //Setter for lastName with validation
    public void setLastName(String lastName) {
        if (!this.validateLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName; //Set valid lastName
    }
    //Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    //Setter for phonenumber with validation
    public void setPhoneNumber(String phoneNumber) {
        if (!this.validatePhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber; //Set valid phoneNumber
    }
    //Getter for address
    public String getAddress() {
        return address;
    }
    //Setter for address with validation
    public void setAddress(String address) {
        if (!this.validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address; //Set valid address
    }
}


package entity;

import java.util.Date;

public class User {
    private static Long counter = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;
    private Date registrationDate;

    public User(String firstName, String lastName, Contact contact, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
        this.id=counter;
        counter++;
        this.registrationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}

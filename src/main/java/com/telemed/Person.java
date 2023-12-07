package com.telemed;

import java.util.Date;

abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String OIB;
    protected Date dateOfBirth;
    protected String username;
    protected String password;

    public Person(String firstName, String lastName, String OIB, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.OIB = OIB;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


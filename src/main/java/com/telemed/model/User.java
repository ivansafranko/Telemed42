package com.telemed.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="APP_USER")
public class User {
    static long idCounter = 0;

    @Id
    @GeneratedValue
    Long id;
    int type = 0; // 0 - patient, 1 - doctor
    protected String firstName;
    protected String lastName;
    protected String OIB;
    protected Date dateOfBirth;
    protected String email;
    protected String password;

    public User() {
    }

    public User(String firstName, String lastName, String OIB, Date dateOfBirth, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.OIB = OIB;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;

        id = idCounter++;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

        id = idCounter++;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }
}


package com.telemed;

import java.util.Date;

public class Patient extends Person{
    public Patient(String firstName, String lastName, String OIB, Date dateOfBirth) {
        super(firstName, lastName, OIB, dateOfBirth);
    }
}

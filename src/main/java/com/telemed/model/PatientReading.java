package com.telemed.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class PatientReading {
    @Id
    @GeneratedValue
    private Long id;
    int systolicBloodPressure;
    int diastolicBloodPressure;
    int heartBeat;
    String note;
    Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PatientReading() {}

    public PatientReading(int systolicBloodPressure, int diastolicBloodPressure, int heartBeat, String note, Date date) {
        this.systolicBloodPressure = systolicBloodPressure;
        this.diastolicBloodPressure = diastolicBloodPressure;
        this.heartBeat = heartBeat;
        this.note = note;
        this.date = date;
    }

    public int getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(int systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public int getDiastolicBloodPressure() {
        return diastolicBloodPressure;
    }

    public void setDiastolicBloodPressure(int diastolicBloodPressure) {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(int heartBeat) {
        this.heartBeat = heartBeat;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }
}

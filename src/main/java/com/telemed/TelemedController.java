package com.telemed;

import com.telemed.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TelemedController {
    User currUser;

    public TelemedController() {

    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientReadingRepository patientReadingRepository;

    @Autowired
    PatientRepository patientRepository;

//    @GetMapping("/init")
//    String init() {
//
//        List<User> testUsers = (List<User>) userRepository.findAll();
//        System.out.println(testUsers);
//
//        User user = new User("admin@mail.com", "test123");
//        user.setType(1);
//        userRepository.save(user);
//
//
//        return "login.html";
//    }

    @GetMapping("/logoutProcess")
    public String logoutProcess(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @GetMapping("/addPatient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "PatientAddNew";
    }

    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute Patient patient) {
        // You might want to set the id to null before saving to ensure it's a new entity
        patient.setId(null);
        patientRepository.save(patient);
        return "redirect:/patientList";
    }

    @GetMapping("/patientReadings")
    public String showPatientReadings(Model model) {
        model.addAttribute("readings", patientReadingRepository.findAll());
        return "PatientHistory.html";
    }

    @GetMapping("/patientReadingEntry")
    public String showPatientReadingEntry() {
        return "PatientReadingsEntry.html";
    }

    @GetMapping("/addNewPatientReading")
    public String addNewPatientReading (int systolicBloodPressure, int diastolicBloodPressure, int heartBeat, String note) {
        PatientReading reading = new PatientReading(systolicBloodPressure, diastolicBloodPressure, heartBeat, note, new Date());
        patientReadingRepository.save(reading);

        return "redirect:/patientReadings";
    }
    @GetMapping("/deletePatientEntry")
    public String deletePatientEntry(Long id) {
        patientReadingRepository.deleteById(id);
        return "redirect:/patientReadings";
    }
}

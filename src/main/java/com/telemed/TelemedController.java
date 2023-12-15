package com.telemed;

import com.telemed.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/login")
    public String showLogin() {
        return "login.html";
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
}



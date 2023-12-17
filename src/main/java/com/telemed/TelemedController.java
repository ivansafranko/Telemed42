package com.telemed;

import com.telemed.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TelemedController {
    User currUser;
    User currentUser = null;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientReadingRepository patientReadingRepository;

    public TelemedController() {
    }

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
    @GetMapping("/history")
    public String showTodos(Model model){
        model.addAttribute(patientReadingRepository.findAllByUser(currentUser));
        model.addAttribute("currentUser", currentUser);

        return "PatientsList.html";
    }
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute(userRepository.findAllByType(0));
        return "PatientsList.html";
    }
    @GetMapping("/loginProcess")
    public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password, Model model){
    User u = userRepository.findUserByEmailAndPassword(email,password);

    if (u == null) {
        model.addAttribute("userMessage", "User not found!");
        return "login.html";
    }
    else {
        currentUser = u;

        if(u.getType() == 0) {
            return "redirect:/history";
        }
        else {
            return "redirect:/users";
        }
    }
    }

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
        model.addAttribute("app_user", new User());
        return "PatientAddNew";
    }

    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute User user) {
        user.setType(0);
        userRepository.save(user);
        return "redirect:/users";
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



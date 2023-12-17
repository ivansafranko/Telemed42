package com.telemed;

import com.telemed.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TelemedController {
    User currentUser = null;

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

    @GetMapping("/history")
    public String history(Model model){
        model.addAttribute(patientReadingRepository.findAllByUser(currentUser));
        model.addAttribute("currentUser", currentUser);

        return "PatientHistory.html";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute(userRepository.findAllByType(0));
        return "PatientReadingsEntry.html";
    }

    @GetMapping("/loginProcess")
    public String loginProcess(@RequestParam("username") String email, @RequestParam("password") String password, Model model){
        User u = userRepository.findByEmailAndPassword(email,password);

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
                return "redirect:/user";
            }
        }
    }
    @GetMapping("/login")
    public String showLogin() {
        return "login.html";
    }
}



package com.telemed;

import jakarta.servlet.http.*;
import java.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class TelemedController {

    @GetMapping("/login")
    public String showLogin() {
        return "login.html";
    }
}

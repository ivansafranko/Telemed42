package com.telemed;

import com.telemed.model.User;
import com.telemed.model.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelemedApp {

    public static void main(String[] args) {
        SpringApplication.run(TelemedApp.class, args);
        System.out.println("Started on port 9090");
    }
}

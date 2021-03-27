package com.gmgauthier.trainer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Trainer2Application {

    public static void main(String[] args) {
        SpringApplication.run(Trainer2Application.class, args);
    }

    @GetMapping("")
    public List<String> root() {
        return List.of("Project", "Root!", "List", "of", "Items");
    }

}

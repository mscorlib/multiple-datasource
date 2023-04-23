package org.example.host.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class AppController {
    @Value("${app.module1}")
    String module1;

    @Value("${app.module2}")
    String module2;

    @Value("${app.module3}")
    String module3;

    @GetMapping("/module1")
    public String module1() {
        return module1;
    }

    @GetMapping("/module2")
    public String module2() {
        return module2;
    }

    @GetMapping("/module3")
    public String module3() {
        return module3;
    }
}

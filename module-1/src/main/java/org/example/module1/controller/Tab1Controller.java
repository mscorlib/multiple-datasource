package org.example.module1.controller;

import org.example.module1.domain.Tab1;
import org.example.module1.mapper.Tab1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tab1")
public class Tab1Controller {

    @Autowired
    private Tab1Mapper mapper;

    @GetMapping("/list")
    public List<Tab1> list(){
        return mapper.getAll();
    }
}

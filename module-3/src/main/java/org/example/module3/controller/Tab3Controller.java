package org.example.module3.controller;

import org.example.module3.domain.Tab3;
import org.example.module3.mapper.Tab3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tab3")
public class Tab3Controller {

    @Autowired
    private Tab3Mapper mapper;

    @GetMapping("/list")
    public List<Tab3> list(){
        return mapper.getAll();
    }
}

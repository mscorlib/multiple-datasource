package org.example.module2.controller;

import org.example.module2.domain.Tab2;
import org.example.module2.mapper.Tab2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tab2")
public class Tab2Controller {

    @Autowired
    private Tab2Mapper mapper;

    @GetMapping("/list")
    public List<Tab2> list(){
        return mapper.getAll();
    }
}

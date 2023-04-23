package org.example.host.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.module1.domain.Tab1;
import org.example.module1.service.Tab1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tab1")
public class Tab1Controller {

    @Autowired
    private Tab1Service service;

    @GetMapping("/list")
    public List<Tab1> list(){

        return service.all();
    }
    @GetMapping("/page")
    public Page<Tab1> page(int index, int rows){
        Page<Tab1> page = PageHelper.startPage(index, rows).doSelectPage(() -> service.all());
        return page;
    }
}

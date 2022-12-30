package org.example.module2.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.module2.domain.Tab2;
import org.example.module2.service.ITab2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tab2")
public class Tab2Controller {

    @Autowired
    private ITab2Service service;

    @GetMapping("/list")
    public List<Tab2> list(){
        return service.all();
    }

    @GetMapping("/page")
    public Page<Tab2> page(int index, int rows){
        Page<Tab2> page = PageHelper.startPage(index, rows).doSelectPage(() -> service.all());
        return page;
    }
}

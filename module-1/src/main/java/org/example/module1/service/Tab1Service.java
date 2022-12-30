package org.example.module1.service;

import org.example.module1.domain.Tab1;
import org.example.module1.mapper.Tab1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tab1Service {
    @Autowired
    private Tab1Mapper mapper;

    public List<Tab1> all(){
        return mapper.getAll();
    }
}

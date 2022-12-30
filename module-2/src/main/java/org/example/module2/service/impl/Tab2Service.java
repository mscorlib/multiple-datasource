package org.example.module2.service.impl;

import org.example.module2.domain.Tab2;
import org.example.module2.mapper.Tab2Mapper;
import org.example.module2.service.ITab2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tab2Service implements ITab2Service {

    @Autowired
    private Tab2Mapper mapper;

    @Override
    public List<Tab2> all() {
        return mapper.getAll();
    }
}

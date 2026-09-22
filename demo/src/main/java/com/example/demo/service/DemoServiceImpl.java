package com.example.demo.service;

import com.example.demo.entity.Demo;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{

    private DemoRepository demoRepo;

    public DemoServiceImpl(DemoRepository demoRepo){
        super();
        this.demoRepo = demoRepo;
    }

    @Override
    public List<Demo> getAllDemos() {
        return demoRepo.findAll();
    }
}

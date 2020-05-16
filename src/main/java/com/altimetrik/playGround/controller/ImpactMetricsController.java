package com.altimetrik.playGround.controller;


import com.altimetrik.playGround.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playground/impact-metrics")
public class ImpactMetricsController  {


    @Autowired
    private IService impactService;

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "helloWorld";
    }
}

package com.pratik.productcatalogue.controllers;

import com.pratik.productcatalogue.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AppController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/health")
    public String healthCheck() {
        return "healthy & up and Good.";
    }

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(defaultValue = "World") String name)  {
    return  new Greeting(counter.incrementAndGet(), String.format(template, name));}

}

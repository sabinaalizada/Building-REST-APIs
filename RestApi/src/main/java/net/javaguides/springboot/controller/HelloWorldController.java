package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody
public class HelloWorldController {

    //HTTP GET Request

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}

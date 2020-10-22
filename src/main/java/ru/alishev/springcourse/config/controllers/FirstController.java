package ru.alishev.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")   // теперь полный адрес до hello или goodbye изменился localhost:8080/first/goodbye
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(){
        return "first/hello";       // и ссылки описанные в html файле работать не будут
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}

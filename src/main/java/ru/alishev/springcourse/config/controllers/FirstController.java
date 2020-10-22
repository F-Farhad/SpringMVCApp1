package ru.alishev.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")   // теперь полный адрес до hello или goodbye изменился localhost:8080/first/goodbye
public class FirstController {

    /*	после аннотации мы указываем название того ключа который мы ожидаем в URL (@RequestParam ("name")).
    Spring сам возьмет этот параметр из URL'а, и положит его в параметр  (String name)*/
    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname){
        System.out.println("Hello, " + name + " " + surname); // получаем готовые параметры и используем их

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}

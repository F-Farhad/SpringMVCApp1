package ru.alishev.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")   // теперь полный адрес до hello или goodbye изменился localhost:8080/first/goodbye
public class FirstController {

    @GetMapping("/hello")
    /*В данном примере используем объект request который содержит все сведения об HTTP запросе
    * и из него мы берем только параметры. */
    /*Что бы передать параметры запрос должен выглядеть так :
    *                                           localhost:8080/first/hello?name=Tom&surname=Holland
    * посел знака ? указывается первый параметр, а второй после &*/
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname); //выводим параметры в консоль

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}

package br.com.cwi.reset.projeto1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHello")

public class HelloWorldController {
    @GetMapping
    public String sayHello(){
        return "Hello World";
    }
}

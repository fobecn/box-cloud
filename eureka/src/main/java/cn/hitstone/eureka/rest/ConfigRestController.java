package cn.hitstone.eureka.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigRestController {

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/config")
    public String getConfigName(){
        return name;
    }
}

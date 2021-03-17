package com.cph.adminstration.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RoutingController {

    @GetMapping("/ankomst")
    public String arrivals(){
        return "ankomst";
    }

}

package org.example.exercise15_week4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping(path="/name")

    public String name(){
        return "My name is Nahj";
    }

    @GetMapping(path = "/age")
    public String age(){
        return "My age is 25";
    }

    @GetMapping(path="/check/status")
    public String checkStatus(){
        return "Everything OK";
    }

    @GetMapping(path="/health")
    public String health(){
        return "Server health is up and running";
    }
    @GetMapping(path="/names")
    public String[] names(){
        String [] names= new String[]{"Nahj", "Mansour", "Alabbad"};
        return names;
    }






}

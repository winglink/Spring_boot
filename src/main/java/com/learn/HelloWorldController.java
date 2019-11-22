package com.learn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class HelloWorldController {
     @RequestMapping(value = "/")
     public  String sayHello(ModelMap map)
     {
         map.addAttribute("message","http://www.xwing.com");
         map.addAttribute("userName","xx");
         map.addAttribute("date", new Date());
         return "hello";

     }
     @RequestMapping("/fragment")
    public  String  fragment() {
          return "fragment";
     }
}

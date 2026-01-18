package com.sa.demothymleaf.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("show-form")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("process-form")
    public String processForm(){
        return "process-form";
    }

    @RequestMapping("show-formV2")
    public String showFormV2(){
        return "helloworld-formV2";
    }
    @RequestMapping("process-formV2")
    public String processFormV2(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "UpperCase! " + theName;
        model.addAttribute("message", result);
        return "process-formV2";
    }
    @RequestMapping("show-formV3")
    public String showFormV3(){
        return "helloworld-formV3";
    }


    //Requestparam ile form üzerindeki alanı otomatik olarak map ediyoruz.
    @RequestMapping("process-formV3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model){

        //String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        String result = "UpperCase! " + theName;
        model.addAttribute("message", result);
        return "process-formV3";
    }

    @GetMapping("show-formV4")
    public String showFormV4(){
        return "helloworld-formV4";
    }


    //Requestparam ile form üzerindeki alanı otomatik olarak map ediyoruz.
    @PostMapping("process-formV4")
    public String processFormV4(@RequestParam("studentName") String theName, Model model){

        //String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        String result = "UpperCase! " + theName;
        model.addAttribute("message", result);
        return "process-formV3";
    }
}

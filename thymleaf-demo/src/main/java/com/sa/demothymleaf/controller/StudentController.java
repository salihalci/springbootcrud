package com.sa.demothymleaf.controller;

import com.sa.demothymleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    //inject from propeties.file

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/show-student-form")
    public String showForm(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student-form";
    }




    @GetMapping("/show-student-form-dropdown")
    public String showFormDropdown(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student-form-dropdown";
    }



    @GetMapping("/show-student-form-dropdown2")
    public String showFormDropdown2(Model theModel) {
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries", countries);

        return "student-form-dropdown2";
    }


    @GetMapping("/show-student-form-radiobutton")
    public String showFormRadioButton(Model theModel) {

        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);

        return "student-form-radiobutton";

    }



    @PostMapping("/process-student-form")
    public String processStudentForm(@ModelAttribute("student") Student theStudent, Model theModel) {

        System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());

        theModel.addAttribute("student", theStudent);
        return "student-confirmation";
    }


}

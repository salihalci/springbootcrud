package com.sa.demothymleaf.controller;

import com.sa.demothymleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
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

    @PostMapping("/process-student-form")
    public String processStudentForm(@ModelAttribute("student") Student theStudent, Model theModel) {
        System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());
        theModel.addAttribute("student", theStudent);
        return "student-confirmation";
    }


}

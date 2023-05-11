package app.student.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.student.com.model.StudentDetails;
import app.student.com.service.StudentService;

@Controller
public class MainController {

    private final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createStudent")
    public String createstudent(@ModelAttribute StudentDetails student, HttpSession session) {

        boolean f = studentService.checkEmail(student.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Id already exists");
        }
        else {
            StudentDetails studentDetails = studentService.createStudent(student);
            if (studentDetails != null) {
                session.setAttribute("msg", "Register Successfully");
            } else {
                session.setAttribute("msg", "Something went wrong on server");
            }
        }

        return "redirect:/register";
    }
}


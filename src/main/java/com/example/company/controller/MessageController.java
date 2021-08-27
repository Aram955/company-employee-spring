package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.model.Employee;
import com.example.company.model.Message;
import com.example.company.repository.EmployeeRepository;
import com.example.company.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageController {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/message")
    public String message(ModelMap modelMap) {
        List<Employee> employeeAll = employeeRepository.findAll();
        modelMap.addAttribute("employeesMessage", employeeAll);
        List<Message> allmessage = messageRepository.findAll();
        modelMap.addAttribute("allmessage", allmessage);

        return "message";
    }


   

    /*@PostMapping("/addMessage")
    public String addMessagePost(@ModelAttribute Message message) {
       messageRepository.save(message);
        return "redirect:/message";
    }*/

    @PostMapping("/addMessage")
    public String addMessagePost(@RequestParam("formId") Employee formId,
                                 @RequestParam("toId") Employee toId,
                                 @RequestParam("message") String messag) {
        Message message = Message.builder()
                .formID(formId)
                .toID(toId)
                .message(messag)
                .build();
        messageRepository.save(message);
        return "redirect:/message";

    }


}

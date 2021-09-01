package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.model.Message;
import com.example.company.security.CurrentUser;
import com.example.company.service.EmployeeService;
import com.example.company.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final EmployeeService employeeService;



    @GetMapping("/message")
    public String getAllEmployees(ModelMap modelMap) {
        List<Employee> employeeAll = employeeService.findAllEmployees();
        modelMap.addAttribute("employeesMessage", employeeAll);
         return "message";
    }

    @GetMapping ("/showMessages")
       public String getAllMessages(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Message> all = messageService.findAllMessagesByToId(currentUser.getEmployee().getId());
        modelMap.addAttribute("messages", all);
        return "showMessages";
    }



        @PostMapping("/sendMessage")
        public String addMessage(@ModelAttribute Message message,@AuthenticationPrincipal CurrentUser currentUser){
        message.setFormID(currentUser.getEmployee());
        messageService.addMessage(message);
            return "redirect:/employee";
        }
}

package com.stefan.internship_assignment.helloWorldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HelloWorldMessageController {

    private final HelloWorldMessageService helloWorldMessageService;

    @Autowired
    public HelloWorldMessageController(HelloWorldMessageService helloWorldMessageService) {
        this.helloWorldMessageService = helloWorldMessageService;
    }

    @GetMapping("/hello-rest")
    public String helloWorld(@RequestParam(required = false, defaultValue = "english") String language) {
        return helloWorldMessageService.getMessageTranslation(language);
    }

    @GetMapping("/hello")
    public ModelAndView helloWorldHTML(@RequestParam(required = false, defaultValue = "english") String language) {
        return helloWorldMessageService.getMessageTranslationHTML(language);
    }

    // Za logovanje koristimo username "user" i sifru koju nam generise Spring (prelistati konzolu)
    @GetMapping("/secure/hello")
    public ModelAndView adminPage() {
        return helloWorldMessageService.getAdminPage();
    }

    @PostMapping("/secure/add")
    public ModelAndView addMessage(@ModelAttribute HelloWorldMessage helloWorldMessage) {
        return helloWorldMessageService.getAddPage(helloWorldMessage);
    }

    @GetMapping("/hello-all-messages")
    public List<HelloWorldMessage> allMessages() {
        return helloWorldMessageService.getAllMessages();
    }
}
package com.stefan.internship_assignment.helloWorldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class HelloWorldMessageService {

    private final HelloWorldMessageRepository helloWorldMessageRepository;

    @Autowired
    public HelloWorldMessageService(HelloWorldMessageRepository helloWorldMessageRepository) {
        this.helloWorldMessageRepository = helloWorldMessageRepository;
    }

    public String getMessageTranslation(String language) {
        Optional<HelloWorldMessage> message = helloWorldMessageRepository.findByLanguage(language);
        if (message.isPresent())
            return message.get().getMessage();
        else
            return "Sorry! Missing translation for language: " + language;
    }

    public ModelAndView getMessageTranslationHTML(String language) {
        String message;

        Optional<HelloWorldMessage> translation = helloWorldMessageRepository.findByLanguage(language);
        if (translation.isPresent())
            message = translation.get().getMessage();
        else
            message = "Sorry! Missing translation for language: " + language;

        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView("admin_page");
        modelAndView.addObject("HelloWorldMessage", new HelloWorldMessage());
        return modelAndView;
    }

    public ModelAndView getAddPage(HelloWorldMessage helloWorldMessage) {

        String notification;
        String language = helloWorldMessage.getLanguage();
        String message = helloWorldMessage.getMessage();

        if (!language.isEmpty() && !message.isEmpty()) {
            notification = "Success!";
            helloWorldMessageRepository.save(helloWorldMessage);
        }
        else {
            notification = "Wrong format!";
        }

        ModelAndView modelAndView = new ModelAndView("admin_page");
        modelAndView.addObject("HelloWorldMessage", new HelloWorldMessage());
        modelAndView.addObject("notification", notification);

        return modelAndView;
    }

    public List<HelloWorldMessage> getAllMessages() {
        return helloWorldMessageRepository.findAll();
    }
}

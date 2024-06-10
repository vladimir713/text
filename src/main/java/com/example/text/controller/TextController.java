package com.example.text.controller;

import com.example.text.repository.TextRepository;
import com.example.text.service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TextController {

    private final TextRepository repository;
    private final TextService textService;

    public TextController(TextRepository repository, TextService textService) {

        this.repository = repository;
        this.textService = textService;
    }

    @GetMapping("/")
    public String getIndex(Model model){

        model.addAttribute("words", repository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addText(String text){

        textService.addText(text);
        return "redirect:/";
    }
}

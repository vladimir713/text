package com.example.text.controller;

import com.example.text.model.Word;
import com.example.text.repository.TextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class TextControllerRest {
    private TextRepository repository;

    public TextControllerRest(TextRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Word> getAllWords(){
        return repository.findAll();
    }
}

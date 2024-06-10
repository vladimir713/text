package com.example.text.service;

import com.example.text.model.Word;
import com.example.text.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class TextService {

    private final TextRepository repository;

    @Autowired
    public TextService(TextRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addText(String s) {
        getTextRefactor(s).stream().forEach(k -> Arrays.stream(getClearSentence(k).split(" "))
                .forEach(v -> {
                            if(!repository.existsWordByName(v)) {
                                repository.save(new Word(v));
                            }
                        }
                ));
    }

    /**
     * Метод, разделяющий текст на предложения
     * @param s - текст
     * @return - список предложений
     */
    private List<String> getTextRefactor(String s) {
        return Arrays.asList(s.split("[.!?,]"));
    }

    private String getClearSentence(String inSentetce){
        return inSentetce.replaceAll("[^А-Яа-я ]", "")
                .replaceAll("(?:^[уУ|кК|вВ|аА|оО|яЯ|сС|иИ| ])", "");
    }
}

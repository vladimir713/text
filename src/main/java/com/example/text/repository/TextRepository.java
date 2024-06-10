package com.example.text.repository;

import com.example.text.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends CrudRepository<Word, Long> {

    boolean existsWordByName(String name);
}

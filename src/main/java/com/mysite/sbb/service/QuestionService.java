package com.mysite.sbb.service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> List() {
        return questionRepository.findAll();
    }

    public Question detail(Integer id) {
        Optional<Question> oq = questionRepository.findById(id);
        if (oq.isPresent()) {
            return oq.get();
        }
        else{
            throw new DataNotFoundException("question not found");
        }
    }
}

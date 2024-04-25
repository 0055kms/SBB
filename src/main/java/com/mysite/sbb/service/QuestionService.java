package com.mysite.sbb.service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    //페이징 기능
    public Page<Question> getList(int page){
        List<Sort.Order> shorts = new ArrayList<>();
        shorts.add(Sort.Order.desc("createTime"));
        Pageable pageable = PageRequest.of(page, 10,Sort.by(shorts));
        return this.questionRepository.findAll(pageable);
    }

    public List<Question> List() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question>oq = questionRepository.findById(id);
        if (oq.isPresent()) {
            return oq.get();
        }
        else{
            throw new DataNotFoundException("question not found");
        }
    }
    public void createQuestion(String subject, String content) {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateTime(LocalDateTime.now());
        questionRepository.save(question);
    }

    
}

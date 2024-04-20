package com.mysite.sbb.service;

import com.mysite.sbb.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;


}

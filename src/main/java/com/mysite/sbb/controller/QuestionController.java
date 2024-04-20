package com.mysite.sbb.controller;

import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.QuestionRepository;
import com.mysite.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String list(Model model) {
        List<Question> questionList = questionService.List();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping("/question/{id}")
    public String detail(Model model, @PathVariable Integer id) {
        Question question = questionService.detail(id);
        model.addAttribute("question", question);
        return "question_detail"; //
    }
}

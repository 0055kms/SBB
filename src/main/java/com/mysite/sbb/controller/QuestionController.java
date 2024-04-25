package com.mysite.sbb.controller;

import com.mysite.sbb.entity.Question;
import com.mysite.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String list(Model model, @RequestParam(name = "page", defaultValue = "0")int page){
        Page<Question> paging = questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping("/question/{id}")
    public String detail(Model model, @PathVariable Integer id) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail"; //
    }

    @GetMapping("/create")
    public String create() {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@RequestParam String subject, @RequestParam String content) {
        this.questionService.createQuestion(subject, content);
        return "redirect:/";
    }
}

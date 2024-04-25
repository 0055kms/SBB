package com.mysite.sbb;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.AnswerRepository;
import com.mysite.sbb.repository.QuestionRepository;
import com.mysite.sbb.service.QuestionService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		for (int i = 0; i<301; i++){
			String subject = (String.format("테스트용 데이터 [%03d]",i));
			String content = "내용은 없음";
			this.questionService.createQuestion(subject, content);
		}
	}

}

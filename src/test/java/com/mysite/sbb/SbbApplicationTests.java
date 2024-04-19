package com.mysite.sbb;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.QuestionRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if (oq.isPresent()){
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
		Question q2 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q2.getId());
	}
}

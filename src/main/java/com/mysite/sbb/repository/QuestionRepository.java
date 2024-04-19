package com.mysite.sbb.repository;

import com.mysite.sbb.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
        Question findBySubject(String subject);
}

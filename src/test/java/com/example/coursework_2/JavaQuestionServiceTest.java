package com.example.coursework_2;

import com.example.coursework_2.model.Question;
import com.example.coursework_2.service.JavaQuestionService;
import com.example.coursework_2.service.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach(){
        questionService.add(new Question("q1", "a1"));
        questionService.add(new Question("q2", "a2"));
        questionService.add(new Question("q3", "a3"));
    }

    @AfterEach
    public void afterEach() {
       new HashSet<>(questionService.getAll()).forEach(questionService::remove);
    }

    @Test
    public void add1Test() {
        int count = questionService.getAll().size();
        Question question = new Question("q4", "a4");
        Assertions.assertThat(questionService.add("q4", "a4"))
                .isEqualTo(question);
    }

    @Test
    public void add2Test() {
        int count = questionService.getAll().size();
        Question question = new Question("q4", "a4");
        Assertions.assertThat(questionService.add(question))
                .isEqualTo(question);
    }

    @Test
    public void removeTest() {
        int count = questionService.getAll().size();
        Question question = new Question("q2", "a2");
        Assertions.assertThat(questionService.remove(question))
                .isEqualTo(question);
    }



}

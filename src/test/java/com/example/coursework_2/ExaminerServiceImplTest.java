package com.example.coursework_2;

import com.example.coursework_2.exceptions.WrongAmountOfQuestions;
import com.example.coursework_2.model.Question;
import com.example.coursework_2.service.ExaminerService;
import com.example.coursework_2.service.ExaminerServiceImpl;
import com.example.coursework_2.service.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Collection<Question> questions = Set.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4"),
            new Question("q5", "a5")
    );

    @Test
    public void getQuestionsNegativeTest() {
        when(questionService.getAll()).thenReturn(questions);
        Assertions.assertThatExceptionOfType(WrongAmountOfQuestions.class)
                .isThrownBy(() -> examinerService.getQuestions(questions.size() + 1));
    }

    @Test
    public void getQuestionsTest() {
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("q1", "a1"),
                new Question("q3", "a3"),
                new Question("q3", "a3"),
                new Question("q4", "a4")
        );
        Assertions.assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("q1", "a1"),
                        new Question("q3", "a3"),
                        new Question("q4", "a4")
                );
    }
}

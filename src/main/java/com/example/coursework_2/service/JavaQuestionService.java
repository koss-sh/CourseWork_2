package com.example.coursework_2.service;

import com.example.coursework_2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return question;
    }

    @Override
    public Question remove(Question question) {
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if(questions.size() == 0)
            throw new RuntimeException("Questions Set is empty");
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}

package com.example.quiz01;

import com.example.quiz01.dto.Answer;
import com.example.quiz01.dto.Quiz;

import java.util.List;

public interface AnswerService {


    public List<Answer> getAnswerList();
    public void uploadanswer(Answer answer);

}

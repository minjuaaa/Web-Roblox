package com.example.quiz01;

import com.example.quiz01.dao.AnswerMapper;
import com.example.quiz01.dao.QuizMapper;
import com.example.quiz01.dto.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private final AnswerMapper answerMapper;


    @Override
    public List<Answer> getAnswerList() {
        return answerMapper.getAnswerList();
    }

    @Override
    public void uploadanswer(Answer answer) {
        answerMapper.uploadanswer(answer);
    }

}

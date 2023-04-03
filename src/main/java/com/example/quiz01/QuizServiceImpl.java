package com.example.quiz01;

import com.example.quiz01.dao.QuizMapper;
import com.example.quiz01.dto.Quiz;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizMapper quizMapper;

//    @Override
//    public List<Quiz> quizfindAll(){
//        return quizMapper.findAll();
//    }

    @Override
    public List<Quiz> quizfindByCode(String gameCode) {
        return quizMapper.findByCode(gameCode);
    }

    @Override
    public Quiz checkAnswer(String gameCode, String num){

        return quizMapper.checkAnswer(gameCode, num);
    }



    @Override
    public void insertQuiz(Quiz quiz){

        quizMapper.insertQuiz(quiz);
    }


}

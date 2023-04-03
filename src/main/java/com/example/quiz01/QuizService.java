package com.example.quiz01;

import com.example.quiz01.dto.Quiz;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface QuizService {

     List<Quiz> quizfindByCode(String gameCode);

     Quiz checkAnswer(String gameCode, String num);


//     Quiz quizNum(HashMap<String, Object> map);


     void insertQuiz(Quiz quiz);


}

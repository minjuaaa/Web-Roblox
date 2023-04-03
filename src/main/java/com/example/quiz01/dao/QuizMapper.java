package com.example.quiz01.dao;

import com.example.quiz01.dto.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface QuizMapper {
//    List<Quiz> findAll();
    List<Quiz> findByCode(String gameCode);

    Quiz checkAnswer(String gameCode, String num);
   // Quiz quizNum(@Param("gameCode")String gameCode, @Param("num")String num);
    Quiz quizNum(@Param("gameCode")String gameCode, @Param("num")String num);
    void insertQuiz(Quiz quiz);




}

package com.example.quiz01.dao;

import com.example.quiz01.dto.Answer;
import com.example.quiz01.dto.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    List<Answer> getAnswerList();
    void uploadanswer(Answer answer);

    Long save(Answer answer);

}


package com.example.quiz01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface GameMapper {


    void uploadgame(@Param("gameTitle") String gameTitle, @Param("gameCode") String gameCode);
}

package com.example.quiz01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.quiz01.dto.Game;


@Mapper
@Repository
public interface GameMapper {

    void uploadgame(Game game);
}

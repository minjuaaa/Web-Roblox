package com.example.quiz01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CsvDataMapper {
    void insertData(@Param("gameCodecsv") String gameCodecsv, @Param("num") String num, @Param("title") String title, @Param("ex1") String ex1, @Param("ex2") String ex2, @Param("ex3") String ex3, @Param("ex4") String ex4, @Param("imageCode") String imageCode, @Param("correct") String correct);
    // 필요한 경우에 따라 추가적인 메서드 정의 가능
}

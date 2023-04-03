package com.example.quiz01.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private String answerId;
    private String gameCode;
    private String num;
    private String answers;


}

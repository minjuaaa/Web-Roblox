package com.example.quiz01.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private String quizId;
    private String gameCode;
    private String title;
    private String ex1;
    private String ex2;
    private String ex3;
    private String ex4;
    private String image;
    private String correct;
    private String answers;

    public Quiz(String quizId, String title, String correct) {
        this.quizId = quizId;
        this.title = title;
        this.correct = correct;

    }
}

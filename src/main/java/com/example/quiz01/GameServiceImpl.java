package com.example.quiz01;

import com.example.quiz01.dao.AnswerMapper;
import com.example.quiz01.dao.GameMapper;
import com.example.quiz01.dto.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameMapper gameMapper;

    @Override
    public void uploadgame(Game game){
        gameMapper.uploadgame(game);
    }

}

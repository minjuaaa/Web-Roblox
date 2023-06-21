package com.example.quiz01;

import com.example.quiz01.dao.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameMapper gameMapper;

    @Override
    public void uploadgame(String gameTitle, String gamecode){
        gameMapper.uploadgame(gameTitle, gamecode);
    }

}

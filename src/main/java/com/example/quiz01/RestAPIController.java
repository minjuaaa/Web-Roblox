package com.example.quiz01;

import com.example.quiz01.dto.Answer;
import com.example.quiz01.dto.Quiz;
import com.example.quiz01.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RestAPIController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private GameService gameService;


    @GetMapping("/quiz/{gamecode}")
    @ResponseBody
    public String quiz(@PathVariable String gamecode) {


        List<Quiz> list = quizService.quizfindByCode(gamecode);

        String html = "";
        for(Quiz q : list) {
            html += q.getTitle() + "," +
                    q.getEx1();
        }
        return html;
    }



    @GetMapping("/answer")
    @ResponseBody
    public String answer(@ModelAttribute Answer answer, Model model){
        System.out.println(answer.getGameCode());   //대소문자 주의
        System.out.println(answer.getNum());

        answerService.uploadanswer(answer);

            return "ok";
        }


        @GetMapping("/search")
    public String game(@RequestParam(name="gameCode", required=false)String gameCode, Model model){
//코드로 문제 정보 불러오기!!!!
        List<Quiz> list = quizService.quizfindByCode(gameCode);

        for(Quiz q : list) {

            List<Answer> answers = answerService.getAnswerList(); // select * from answer where gamecode = "" and num = q["num"]
            String result = "";

            for(Answer ans : answers) {
                result += answerService.getAnswerList() + ",";
            }
            q.setAnswers(result);
        }
        model.addAttribute("quizs", list);
        return "result";
    }
//



//임시파일로 저장하고 읽어서 insert 하는 방법

    @RequestMapping("/upload/csv")
    public String fileUpload(@RequestParam("uploadFile") MultipartFile file, Model model, Game game) throws IOException {
        String savedFileName = "";
        // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치
        String uploadPath = "C:/Users/SAMSUNG/Desktop/yh/quiz01_0930/csv/";
        // 2. 원본 파일 이름 알아오기
        String originalFileName = file.getOriginalFilename();
        // 3. 파일 이름 중복되지 않게 이름 변경(서버에 저장할 이름) UUID 사용
        UUID uuid = UUID.randomUUID();
        savedFileName = uuid.toString() + "_" + originalFileName;
        // 4. 파일 생성
        File file1 = new File(uploadPath + savedFileName);
        // 5. 서버로 전송
        file.transferTo(file1);

        //csv 읽기(한줄씩)


        //, 기준 split
        //quizinsert 문장

                //구현순서 1.quiz insert 먼저 2.csv읽기 3.index로 조회 4.퀴즈서비스호출


        // model로 저장
        model.addAttribute("originalFileName", originalFileName);

        gameService.uploadgame(game);
        return "upload";
    }







    @PostMapping("/insertquiz")
    public String insertQuiz(Quiz quiz){
        quizService.insertQuiz(quiz);
        return "redirect:/upload";
    }



}

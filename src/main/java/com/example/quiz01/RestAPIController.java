package com.example.quiz01;

import com.example.quiz01.dao.CsvDataMapper;
import com.example.quiz01.dto.Answer;
import com.example.quiz01.dto.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Controller
public class RestAPIController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private CsvDataMapper csvDataMapper;


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






    @PostMapping("/upload/csv")
    public String handleFileUpload(@RequestParam("uploadFile") MultipartFile file,
                                   @RequestParam("gameTitle") String gameTitle,
                                   @RequestParam("gameCode") String gameCode) {
        if (!file.isEmpty()) {
            try {
                // 파일 저장
                String filename = file.getOriginalFilename();
                String tempFilePath = "C:/Users/SAMSUNG/Desktop/yh/quiz01_0930/csv/" + filename;
                File tempFile = new File(tempFilePath);
                file.transferTo(tempFile);

                gameService.uploadgame(gameTitle, gameCode);
                int num = 0;
                // CSV 데이터 처리
                List<String[]> csvData = readCSVData(new BufferedReader(new FileReader(tempFile)));
                for (String[] row : csvData) {
                        // 각 행의 데이터를 추출하여 데이터베이스에 저장
                        String gameCodecsv = gameCode;
                        num = num+1;
                        String title = row[0];
                        String ex1 = row[1];
                        String ex2 = row[2];
                        String ex3 = row[3];
                        String ex4 = row[4];
                        String imagecode = row[5];
                        String correct = row[6];


                        // 데이터베이스에 저장
                        csvDataMapper.insertData(gameCodecsv, String.valueOf(num), title, ex1, ex2, ex3, ex4, imagecode, correct);

                }

                // 임시 파일 삭제
                tempFile.delete();

                return "redirect:/upload";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/error";
    }

    private List<String[]> readCSVData(BufferedReader reader) throws IOException {
        List<String[]> data = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            data.add(row);
        }

        return data;
    }










    @PostMapping("/insertquiz")
    public String insertQuiz(Quiz quiz){
        quizService.insertQuiz(quiz);
        return "redirect:/upload";
    }



}

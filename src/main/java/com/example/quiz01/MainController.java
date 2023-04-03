package com.example.quiz01;

import com.example.quiz01.dto.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {


    @RequestMapping("/")
    public String home(){
        return "index";
    }


    @RequestMapping("upload")
    public String upload(){
        return "upload";
    }





}

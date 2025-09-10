package com.question.service.controller;

import com.question.service.dto.QuestionDto;
import com.question.service.entity.Questions;
import com.question.service.request.QuizRequest;
import com.question.service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        List<Questions> questionsList = this.questionService.getAllQuestions();
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }

    @GetMapping("/getQuestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam int noOfQ,
                                                             @RequestParam String category){
        List<Integer> questionIdList= questionService.getQuestionsForQuiz(noOfQ,category);
return new ResponseEntity<>(questionIdList, HttpStatus.OK);
    }

    @GetMapping("/getQuestionByQuestionIds")
    public ResponseEntity<List<QuestionDto>> getQuestions(@RequestBody List<Integer> questionIds){
        List<QuestionDto> questionList = questionService.getListOfQuestionsByQuestionId(questionIds);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }

    @GetMapping("/result")
    public ResponseEntity<Integer> getResult(@RequestBody List<QuizRequest> quizRequestList){
        int result = questionService.getResult(quizRequestList);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }










}

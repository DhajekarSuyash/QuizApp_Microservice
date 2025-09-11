package com.quiz.service.feign;

import com.quiz.service.dto.QuestionDto;
import com.quiz.service.request.QuizRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUIZ-QUESTION-SERVICE")
public interface QuestionInterface {

    @GetMapping("/questions/getQuestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam int noOfQ,
                                                             @RequestParam String category);

    @PostMapping("/questions/getQuestionByQuestionIds")
    public ResponseEntity<List<QuestionDto>> getQuestions(@RequestBody List<Integer> questionIds);

    @PostMapping("/questions/result")
    public ResponseEntity<Integer> getResult(@RequestBody List<QuizRequest> quizRequestList);


}

package com.quiz.service.service;


import com.quiz.service.dto.QuestionDto;
import com.quiz.service.request.QuizRequest;

import java.util.List;

public interface QuizService {

    String createQuiz(String quizName,int noOfQuestions,String category);

    List<QuestionDto> getQuizQuestions(int id);

    String submitQuiz(List<QuizRequest> request, int quizId);
}

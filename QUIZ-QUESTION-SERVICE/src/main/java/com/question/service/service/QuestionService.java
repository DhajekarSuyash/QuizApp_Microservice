package com.question.service.service;

import com.question.service.dto.QuestionDto;
import com.question.service.entity.Questions;
import com.question.service.request.QuizRequest;


import java.util.List;

public interface QuestionService {

    public List<Questions> getAllQuestions();


    List<Integer> getQuestionsForQuiz(int noOfQ, String category);

    List<QuestionDto> getListOfQuestionsByQuestionId(List<Integer> questionIds);

    int getResult(List<QuizRequest> quizRequestList);
}

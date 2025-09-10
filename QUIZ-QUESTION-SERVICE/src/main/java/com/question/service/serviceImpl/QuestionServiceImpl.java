package com.question.service.serviceImpl;

import com.question.service.dto.QuestionDto;
import com.question.service.entity.Questions;
import com.question.service.repository.QuestionRepository;
import com.question.service.request.QuizRequest;
import com.question.service.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Questions> getAllQuestions() {

        List<Questions> questionsList = this.questionRepository.findAll();
        return questionsList;
    }

    @Override
    public List<Integer> getQuestionsForQuiz(int noOfQ, String category) {
        List<Questions> randomQuestions = questionRepository.findRandomQuestions(noOfQ, category);

        List<Integer> questionIdList = new ArrayList<>();
        for(Questions q : randomQuestions){
            questionIdList.add(q.getId());
        }
        return questionIdList;
    }

    @Override
    public List<QuestionDto> getListOfQuestionsByQuestionId(List<Integer> questionIds) {
        List<QuestionDto> list = new ArrayList<>();
        for(int id : questionIds){
            Questions q = questionRepository.findById(id).get();
            QuestionDto dto = new QuestionDto(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            list.add(dto);
        }
        return list;
    }

    @Override
    public int getResult(List<QuizRequest> quizRequestList) {
        //Homework
        // do not change method signature
        // do not dare to integrate Quiz repository
        return 0;
    }
}

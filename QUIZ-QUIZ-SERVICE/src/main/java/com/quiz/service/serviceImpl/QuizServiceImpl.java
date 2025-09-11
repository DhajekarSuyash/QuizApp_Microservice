package com.quiz.service.serviceImpl;


import com.quiz.service.dto.QuestionDto;
import com.quiz.service.entity.Questions;
import com.quiz.service.entity.Quiz;
import com.quiz.service.feign.QuestionInterface;
import com.quiz.service.repository.QuizRepository;
import com.quiz.service.request.QuizRequest;
import com.quiz.service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    
    @Autowired
    private QuestionInterface questionInterface;


    @Override
    public String createQuiz(String quizName, int noOfQuestions, String category) {

        Quiz quiz = new Quiz();
        quiz.setTitle(quizName);

        //API - localhost:8081/questions/getQuestions  -> RESTTemplate
        // By using feign client


        // q,o1,o2,o3,o4
        List<Integer> questionIdList = questionInterface.getQuestionsForQuiz(noOfQuestions, category).getBody();

        //   List<Questions> quizQuestions = questionRepos.findRandomQuestions(noOfQuestions, category);



       quiz.setQuestionList(questionIdList);
        quizRepository.save(quiz);
        String msg = "Quiz created with id ";
        return msg;
    }

    @Override
    public List<QuestionDto> getQuizQuestions(int id) {
//        Quiz quiz = quizRepository.findById(id).get();
//        List<Questions> questionList = quiz.getQuestionList();
//        List<QuestionDto> questionDtoList = new ArrayList<>();
//        for (Questions q : questionList) {
//            QuestionDto dto = new QuestionDto(q.getId(), q.getQuestion(),
//                    q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//            questionDtoList.add(dto);
//
//        }
//        return questionDtoList;
        return null;

    }

    @Override
    public String submitQuiz(List<QuizRequest> request, int quizId) {

//        Quiz quiz = quizRepository.findById(quizId).get();
//        List<Questions> questionListOfQuiz = quiz.getQuestionList();
//        int correctAnswer = 0;
//        for(Questions q:questionListOfQuiz){
//            for(QuizRequest quizRequest :request ){
//                if(quizRequest.getqId() == q.getId()){
//                    if(quizRequest.getOptionSelect() == q.getCorrectOption()){
//                        correctAnswer++;
//                    }
//                }
//                else{
//                    //question is not from Quiz
//                }
//            }
//        }
//
////
////        for(QuizRequest quizRequest : request){
////            int questionId = quizRequest.getqId();
////            Questions question = questionRepository.findById(questionId).get();
////            if(quizRequest.getOptionSelect() == question.getCorrectOption() ){
////                //true then correcct answer
////                correctAnswer++;
////
////            }
////
////
////        }
//
//        String msg = "Your score is : " + correctAnswer;
//
//        return msg;
        return null;
    }
}

package com.demo.WebExam.Service;

import com.demo.WebExam.Entity.Answer;
import com.demo.WebExam.Entity.Questions;
import com.demo.WebExam.Repository.AnswerRepository;
import com.demo.WebExam.Repository.QuestionRepository;
import com.demo.WebExam.RequestEntity.RequestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }
    public List<Answer> getAllAnswer(){
        return answerRepository.findAll();
    }
    public List<Answer> getAnswerOfQuestion(UUID questionId){
        return answerRepository.findByQuestionId(questionId);
    }
    public Answer createNewAnswer(RequestAnswer answer){
        System.out.println(answer.getAnswerContent());
        System.out.println(answer.getAnswerDescribe());
        Answer newAnswer = new Answer();
        newAnswer.setAnswerContent(answer.getAnswerContent());
        newAnswer.setAnswerDescribe(answer.getAnswerDescribe());
        newAnswer.setCorrect(answer.getCorrect());
        if(answer.getQuestionId() != null){
        Optional<Questions> optionalQuestions = questionRepository.findById(answer.getQuestionId());
        Questions questions = optionalQuestions.get();
        newAnswer.setQuestionId(questions);
        }
        return answerRepository.save(newAnswer);
    }
    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);}
    public void deleteAnswerById(UUID answerId){
        answerRepository.deleteById(answerId);
    }
    public void deleteAnswer(Answer answer){
        answerRepository.delete(answer);
    }




}

package com.demo.WebExam.Service;

import com.demo.WebExam.Entity.Answer;
import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Entity.Questions;
import com.demo.WebExam.Repository.AnswerRepository;
import com.demo.WebExam.Repository.QuestionPackRepository;
import com.demo.WebExam.Repository.QuestionRepository;
import com.demo.WebExam.RequestEntity.RequestQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionPackRepository questionPackRepository;
    private final AnswerRepository answerRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository, QuestionPackRepository questionPackRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.questionPackRepository = questionPackRepository;
        this.answerRepository = answerRepository;
    }
    public List<Questions> getAllQuestion(){
        return questionRepository.findAll();
    }
    public List<Questions> getQuestionFromQuestionPack(UUID questionPackId){
        return questionRepository.findByQuestionPackId(questionPackId);
    }
    public Questions createQuestion(RequestQuestion questions){
        Questions newQuestions = new Questions();
        newQuestions.setQuestionText(questions.getQuestionText());
        if(questions.getQuestionPackId() != null) {
            Optional<QuestionPack> OpQuestionPack = questionPackRepository.findById(questions.getQuestionPackId());
            QuestionPack questionPack = OpQuestionPack.get();
            newQuestions.setQuestionPackId(questionPack);
        }
        newQuestions.setAnswers(questions.getAnswerSet());
        questionRepository.save(newQuestions);
        return newQuestions;
    }
    public void deleteQuestion(Questions questions){
        questionRepository.delete(questions);
    }
    public Questions updateQuestion(Questions questions){
        questionRepository.save(questions);
        return questions;
    }

    public List<Questions> getQuestionFromQuestionPackId(UUID questionPackId) {
        List<Questions> questionsList = questionRepository.findByQuestionPackId(questionPackId);
        return questionsList;
    }

    public Questions getQuestion(UUID questionId) {
        return questionRepository.findById(questionId).get();
    }
}

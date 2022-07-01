package com.demo.WebExam.Service;

import com.demo.WebExam.Entity.Exam;
import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Entity.Questions;
import com.demo.WebExam.Repository.ExamRepository;
import com.demo.WebExam.Repository.QuestionPackRepository;
import com.demo.WebExam.Repository.QuestionRepository;
import com.demo.WebExam.RequestEntity.RequestQuestionPack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class QuestionPackService {
    @Autowired
    private final QuestionPackRepository questionPackRepository;
    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public QuestionPackService(QuestionPackRepository questionPackRepository, QuestionRepository questionRepository, ExamRepository examRepository) {
        this.questionPackRepository = questionPackRepository;
        this.questionRepository = questionRepository;
        this.examRepository = examRepository;
    }
    public List<QuestionPack> getAllQuestionPack(){
        return questionPackRepository.findAll();
    }
    public QuestionPack getQuestionPack(UUID questionPackId){
        Optional<QuestionPack> optionalQuestionPack = questionPackRepository.findById(questionPackId);
        return optionalQuestionPack.get();
    }
    public QuestionPack createQuestionPack(RequestQuestionPack requestQuestionPack){
        QuestionPack newQuestionPack = new QuestionPack();
        newQuestionPack.setQuestionPackName(requestQuestionPack.getQuestionPackName());
        newQuestionPack.setQuestionPackNOQ(requestQuestionPack.getQuestionPackNOQ());
        newQuestionPack.setQuestionPackNOU(requestQuestionPack.getQuestionPackNOU());
        if(!requestQuestionPack.getQuestionsList().isEmpty()) {
            Set<Questions> questionsSet = null;
            for (UUID questionId :
                    requestQuestionPack.getQuestionsList()) {
                Optional<Questions> optionalQuestions = questionRepository.findById(questionId);
                if (optionalQuestions.isPresent())
                    questionsSet.add(optionalQuestions.get());
            }
            newQuestionPack.setQuestions(questionsSet);
        }
        if(!requestQuestionPack.getExamsList().isEmpty()) {
            Set<Exam> examSet = null;
            for (UUID examId :
                    requestQuestionPack.getExamsList()) {
                Optional<Exam> optionalExam = examRepository.findById(examId);
                if (optionalExam.isPresent())
                    examSet.add(optionalExam.get());
            }
            newQuestionPack.setExams(examSet);
        }
        questionPackRepository.save(newQuestionPack);
        return newQuestionPack;
    }
    public void deleteQuestionPackById(UUID questionPackId){
        questionPackRepository.deleteById(questionPackId);
    }
    public QuestionPack updateQuestionPack(QuestionPack questionPack){
        if(questionPackRepository.findById(questionPack.getQuestionPackId()).isPresent())
            questionPackRepository.save(questionPack);
        return questionPack;
    }
}

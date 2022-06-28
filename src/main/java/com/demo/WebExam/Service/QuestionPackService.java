package com.demo.WebExam.Service;

import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Repository.QuestionPackRepository;
import com.demo.WebExam.RequestEntity.RequestQuestionPack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionPackService {
    @Autowired
    private final QuestionPackRepository questionPackRepository;

    public QuestionPackService(QuestionPackRepository questionPackRepository) {
        this.questionPackRepository = questionPackRepository;
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
        newQuestionPack.setQuestions(requestQuestionPack.getQuestions());
        newQuestionPack.setExams(requestQuestionPack.getExams());
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

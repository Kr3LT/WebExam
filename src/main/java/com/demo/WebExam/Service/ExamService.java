package com.demo.WebExam.Service;

import com.demo.WebExam.Entity.Exam;
import com.demo.WebExam.Entity.ExamCategory;
import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Repository.ExamCategoryRepository;
import com.demo.WebExam.Repository.ExamRepository;
import com.demo.WebExam.Repository.QuestionPackRepository;
import com.demo.WebExam.RequestEntity.RequestExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final ExamCategoryRepository examCategoryRepository;
    private final QuestionPackRepository questionPackRepository;
    @Autowired
    public ExamService(ExamRepository examRepository, ExamCategoryRepository examCategoryRepository, QuestionPackRepository questionPackRepository) {
        this.examRepository = examRepository;
        this.examCategoryRepository = examCategoryRepository;
        this.questionPackRepository = questionPackRepository;
    }

    public List<Exam> getAllExam(){
        return examRepository.findAll();
    }
    public Exam createExam(RequestExam exam){
        Exam newExam = new Exam();
        newExam.setExamName(exam.getExamName());
        newExam.setExamTime(exam.getExamTime());
        if(exam.getExamCategoryId() != null){
            Optional<ExamCategory> OpExCategory = examCategoryRepository.findById(exam.getExamCategoryId());
            ExamCategory ExCategory = OpExCategory.get();
            newExam.setExamCategoryId(ExCategory);
        }
        if(exam.getQuestionPackId() != null) {
            Optional<QuestionPack> OpQuPack = questionPackRepository.findById(exam.getQuestionPackId());
            QuestionPack QuPack = OpQuPack.get();
            newExam.setQuestionPackId(QuPack);
        }
        return examRepository.save(newExam);
    }
    public void deleteExam(UUID examId){
        examRepository.deleteById(examId);
    }
    public Exam updateExam(Exam exam){
        if(examRepository.findById(exam.getExamId()).isPresent()){
            return examRepository.save(exam);
        }
        return null;
    }

    public List<Exam> getExamFromExamCategory(UUID examCategoryId) {
        return examRepository.findAllByExamCategoryId(examCategoryId);
    }
}

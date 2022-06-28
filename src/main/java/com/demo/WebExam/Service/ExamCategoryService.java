package com.demo.WebExam.Service;

import com.demo.WebExam.Entity.Exam;
import com.demo.WebExam.Entity.ExamCategory;
import com.demo.WebExam.Repository.ExamCategoryRepository;
import com.demo.WebExam.RequestEntity.RequestExamCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamCategoryService {
    private final ExamCategoryRepository examCategoryRepository;
    @Autowired
    public ExamCategoryService(ExamCategoryRepository examCategoryRepository) {
        this.examCategoryRepository = examCategoryRepository;
    }
    public List<ExamCategory> getAllExamCategory(){
        return examCategoryRepository.findAll();
    }
    public ExamCategory createExamCategory(RequestExamCategory examCategory){
        ExamCategory newExamCategory = new ExamCategory();
        newExamCategory.setExamCategoryName(examCategory.getExamCategoryName());
        return examCategoryRepository.save(newExamCategory);
    }
    public void deleteExamCategory(UUID examcid) {
         examCategoryRepository.deleteById(examcid);
    }

    public ExamCategory updateExamCategory(ExamCategory examCategory){
        return examCategoryRepository.save(examCategory);
    }
}

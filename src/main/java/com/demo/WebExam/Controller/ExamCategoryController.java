package com.demo.WebExam.Controller;

import com.demo.WebExam.Entity.ExamCategory;
import com.demo.WebExam.RequestEntity.RequestExamCategory;
import com.demo.WebExam.Service.ExamCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ExamCategory")
public class ExamCategoryController {
    private final ExamCategoryService examCategoryService;
    @Autowired
    public ExamCategoryController(ExamCategoryService examCategoryService) {
        this.examCategoryService = examCategoryService;
    }
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ExamCategory>> getAllExamCategory(){
        return ResponseEntity.ok(examCategoryService.getAllExamCategory());
    }
    @PostMapping(path = "")
    public ResponseEntity<ExamCategory> createNewExamCategory(@RequestBody RequestExamCategory examCategory){
        return ResponseEntity.ok(examCategoryService.createExamCategory(examCategory));
    }
    @PutMapping()
    public ResponseEntity<ExamCategory> updateExamCategory(@RequestBody ExamCategory examCategory){
        return ResponseEntity.ok(examCategoryService.updateExamCategory(examCategory));
    }
    @DeleteMapping()
    public ResponseEntity<ExamCategory> deleteExamCategory(@RequestBody ExamCategory examCategory){
        examCategoryService.deleteExamCategory(examCategory.getExamCategoryId());
        return ResponseEntity.noContent().build();
    }
}

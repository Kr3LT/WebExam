package com.demo.WebExam.Controller;

import com.demo.WebExam.Entity.Exam;
import com.demo.WebExam.Entity.ExamCategory;
import com.demo.WebExam.RequestEntity.RequestExam;
import com.demo.WebExam.Service.ExamCategoryService;
import com.demo.WebExam.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/Exam")
public class ExamController {
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Exam>> getAllExam(){
        return ResponseEntity.ok(examService.getAllExam());
    }
    @GetMapping(path = "/get/{examCategoryId}")
    public ResponseEntity<List<Exam>> getExamFromExamCategory(@PathVariable UUID examCategoryId){
        List<Exam> exams = examService.getExamFromExamCategory(examCategoryId);
        return ResponseEntity.ok(exams);
    }
    @PostMapping(path = "")
    public ResponseEntity<Exam> createNewExam(@RequestBody RequestExam exam){
        Exam newExam = examService.createExam(exam);
       return ResponseEntity.ok(newExam);
    }
    @PutMapping(path = "")
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.updateExam(exam));
    }
    @DeleteMapping(path = "")
    public ResponseEntity<Exam> deleteExam(@RequestBody UUID examid){
        examService.deleteExam(examid);
        return ResponseEntity.noContent().build();
    }
}

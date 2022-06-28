package com.demo.WebExam.Controller;

import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Repository.QuestionPackRepository;
import com.demo.WebExam.RequestEntity.RequestQuestionPack;
import com.demo.WebExam.Service.QuestionPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/QuestionPack")
public class QuestionPackController {
    private final QuestionPackService questionPackService;
    @Autowired
    public QuestionPackController(QuestionPackService questionPackService) {
        this.questionPackService = questionPackService;
            }
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<QuestionPack>> getAllQuestionPack(){
        return ResponseEntity.ok(questionPackService.getAllQuestionPack());
    }
    @GetMapping(path = "/get/{questionPackId}")
    public ResponseEntity<QuestionPack> getQuestionPack(@PathVariable UUID questionPackId){
        return ResponseEntity.ok(questionPackService.getQuestionPack(questionPackId));
    }
    @PostMapping()
    public ResponseEntity<QuestionPack> createQuestionPack(@RequestBody RequestQuestionPack requestQuestionPack){
        return ResponseEntity.ok(questionPackService.createQuestionPack(requestQuestionPack));
    }
    @PutMapping()
    public ResponseEntity<QuestionPack> updateQuestionPack(@RequestBody QuestionPack questionPack){
        return ResponseEntity.ok(questionPackService.updateQuestionPack(questionPack));
    }
    @DeleteMapping()
    public ResponseEntity<QuestionPack> deleteQuestionPackById(@RequestBody UUID questionPackId){
        questionPackService.deleteQuestionPackById(questionPackId);
        return ResponseEntity.noContent().build();
    }




}

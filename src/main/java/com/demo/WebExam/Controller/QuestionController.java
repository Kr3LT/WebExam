package com.demo.WebExam.Controller;

import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Entity.Questions;
import com.demo.WebExam.RequestEntity.RequestQuestion;
import com.demo.WebExam.Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/Question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Questions>> getAllQuestion(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }
    @GetMapping(path = "/getPack/{questionPackId}")
    public ResponseEntity<List<Questions>> getQuestionsFromQuestonPackId(@PathVariable UUID questionPackId){
        return ResponseEntity.ok(questionService.getQuestionFromQuestionPackId(questionPackId));
    }
    @GetMapping(path = "/get/{questionId}")
    public ResponseEntity<Questions> getQuestion(@PathVariable UUID questionId){
        return ResponseEntity.ok(questionService.getQuestion(questionId));
    }
    @PostMapping()
    public ResponseEntity<Questions> createNewQuestion(@RequestBody RequestQuestion question){
        return ResponseEntity.ok(questionService.createQuestion(question));
    }
    @PutMapping
    public ResponseEntity<Questions> updateQuestion(@RequestBody Questions question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }
    @DeleteMapping
    public ResponseEntity<Questions> deleteQuestion(@RequestBody Questions question){
        questionService.deleteQuestion(question);
        return ResponseEntity.noContent().build();
    }
}

package com.demo.WebExam.Controller;

import com.demo.WebExam.Entity.Answer;
import com.demo.WebExam.RequestEntity.RequestAnswer;
import com.demo.WebExam.Service.AnswerService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/Answer")
public class AnswerController {
    private final AnswerService answerService;
    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Answer>> getAllAnswer(){
        return ResponseEntity.ok(answerService.getAllAnswer());
    }
    @GetMapping(path = "/{questionId}")
    public ResponseEntity<List<Answer>> getAnswerFromQuestionId(@PathVariable UUID questionId){
        List<Answer> answers = answerService.getAnswerOfQuestion(questionId);
        if(answers == null)
            return ResponseEntity.notFound().build();
        else
        return ResponseEntity.ok(answers);
    }
    @PostMapping(path = "")
    public ResponseEntity<Answer> createAnswer(@RequestBody RequestAnswer answer){
        Answer newAnswer = answerService.createNewAnswer(answer);
        return ResponseEntity.ok(newAnswer);
    }
    @DeleteMapping(path = "")
    public HttpStatus deleteAnswer(@RequestBody Answer answer){
        answerService.deleteAnswer(answer);
        return HttpStatus.OK;
    }
    @DeleteMapping(path = "/{answerId}")
    public ResponseEntity deleteAnswerById(@PathVariable UUID answerId){
        answerService.deleteAnswerById(answerId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer){
        return ResponseEntity.ok(answerService.updateAnswer(answer));
    }
}

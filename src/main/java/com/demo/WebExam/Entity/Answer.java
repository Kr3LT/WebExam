package com.demo.WebExam.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    private UUID answerId = UUID.randomUUID();
    @Column
    private String answerContent;
    @Column
    private boolean isCorrect;
    @Column
    private String answerDescribe;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Questions questionId;

    public Answer(String answerContent, boolean isCorrect, String answerDescribe) {
        this.answerContent = answerContent;
        this.isCorrect = isCorrect;
        this.answerDescribe = answerDescribe;
    }

    public Answer() {
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

   public String getAnswerDescribe() {
        return answerDescribe;
    }

    public void setAnswerDescribe(String answerDescribe) {
        this.answerDescribe = answerDescribe;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }
}

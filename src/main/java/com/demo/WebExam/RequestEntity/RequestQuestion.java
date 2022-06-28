package com.demo.WebExam.RequestEntity;

import com.demo.WebExam.Entity.Answer;

import java.util.Set;
import java.util.UUID;

public class RequestQuestion {
    private String questionText;
    private UUID questionPackId;
    private Set<Answer> answerSet;

    public RequestQuestion() {
    }

    public RequestQuestion(String questionText, UUID questionPackId, Set<Answer> answerSet) {
        this.questionText = questionText;
        this.questionPackId = questionPackId;
        this.answerSet = answerSet;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public UUID getQuestionPackId() {
        return questionPackId;
    }

    public void setQuestionPackId(UUID questionPackId) {
        this.questionPackId = questionPackId;
    }

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }
}

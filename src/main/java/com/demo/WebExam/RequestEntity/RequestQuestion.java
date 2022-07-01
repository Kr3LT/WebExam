package com.demo.WebExam.RequestEntity;

import java.util.List;
import java.util.UUID;

public class RequestQuestion {
    private String questionText;
    private UUID questionPackId;
    private List<UUID> answerList;

    public RequestQuestion() {
    }

    public RequestQuestion(String questionText, UUID questionPackId, List<UUID> answerSet) {
        this.questionText = questionText;
        this.questionPackId = questionPackId;
        this.answerList = answerSet;
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

    public List<UUID> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<UUID> answerList) {
        this.answerList = answerList;
    }
}

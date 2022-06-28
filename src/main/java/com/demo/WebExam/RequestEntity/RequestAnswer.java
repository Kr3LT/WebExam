package com.demo.WebExam.RequestEntity;

import java.util.UUID;

public class RequestAnswer {
    private String AnswerContent;
    private boolean isCorrect;
    private String AnswerDescribe;
    private UUID questionId;

    public RequestAnswer() {
    }

    public RequestAnswer(String answerContent, Boolean isCorrect, String answerDescribe, UUID questionId) {
        AnswerContent = answerContent;
        this.isCorrect = isCorrect;
        AnswerDescribe = answerDescribe;
        this.questionId = questionId;
    }

    public String getAnswerContent() {
        return AnswerContent;
    }

    public void setAnswerContent(String answerContent) {
        AnswerContent = answerContent;
    }

    public boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public String getAnswerDescribe() {
        return AnswerDescribe;
    }

    public void setAnswerDescribe(String answerDescribe) {
        AnswerDescribe = answerDescribe;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }
}

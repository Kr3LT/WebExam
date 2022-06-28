package com.demo.WebExam.RequestEntity;

import java.util.UUID;

public class RequestExam {
    private String examName;
    private int examTime;
    private UUID questionPackId;
    private UUID examCategoryId;

    public RequestExam() {
    }

    public RequestExam(String examName, int examTime, UUID questionPackId, UUID examCategoryId) {
        this.examName = examName;
        this.examTime = examTime;
        this.questionPackId = questionPackId;
        this.examCategoryId = examCategoryId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamTime() {
        return examTime;
    }

    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }

    public UUID getQuestionPackId() {
        return questionPackId;
    }

    public void setQuestionPackId(UUID questionPackId) {
        this.questionPackId = questionPackId;
    }

    public UUID getExamCategoryId() {
        return examCategoryId;
    }

    public void setExamCategoryId(UUID examCategoryId) {
        this.examCategoryId = examCategoryId;
    }
}

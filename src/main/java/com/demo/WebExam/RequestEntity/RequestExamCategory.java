package com.demo.WebExam.RequestEntity;

import com.demo.WebExam.Entity.Exam;

import java.util.Set;

public class RequestExamCategory {
    private String examCategoryName;
    private Set<Exam> examSet;

    public RequestExamCategory() {
    }

    public RequestExamCategory(String examCategoryName, Set<Exam> examSet) {
        this.examCategoryName = examCategoryName;
        this.examSet = examSet;
    }

    public String getExamCategoryName() {
        return examCategoryName;
    }

    public void setExamCategoryName(String examCategoryName) {
        this.examCategoryName = examCategoryName;
    }

    public Set<Exam> getExamSet() {
        return examSet;
    }

    public void setExamSet(Set<Exam> examSet) {
        this.examSet = examSet;
    }
}

package com.demo.WebExam.RequestEntity;

import com.demo.WebExam.Entity.Exam;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class RequestExamCategory {
    private String examCategoryName;
    private List<UUID> examIdList;

    public RequestExamCategory() {
    }

    public RequestExamCategory(String examCategoryName, List<UUID> examIdList) {
        this.examCategoryName = examCategoryName;
        this.examIdList = examIdList;
    }

    public String getExamCategoryName() {
        return examCategoryName;
    }

    public void setExamCategoryName(String examCategoryName) {
        this.examCategoryName = examCategoryName;
    }

    public List<UUID> getExamIdList() {
        return examIdList;
    }

    public void setExamIdList(List<UUID> examIdList) {
        this.examIdList = examIdList;
    }
}

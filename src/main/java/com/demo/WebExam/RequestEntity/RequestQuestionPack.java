package com.demo.WebExam.RequestEntity;

import com.demo.WebExam.Entity.Exam;
import com.demo.WebExam.Entity.Questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class RequestQuestionPack {
    private String questionPackName;
    private int questionPackNOQ;
    private int questionPackNOU;
    private List<UUID> questionsList;
    private List<UUID> examsList;

    public RequestQuestionPack(String questionPackName, int questionPackNOQ, int questionPackNOU, List<UUID> questionsList, List<UUID> examsList) {
        this.questionPackName = questionPackName;
        this.questionPackNOQ = questionPackNOQ;
        this.questionPackNOU = questionPackNOU;
        this.questionsList = questionsList;
        this.examsList = examsList;
    }


    public RequestQuestionPack() {
    }

    public String getQuestionPackName() {
        return questionPackName;
    }

    public void setQuestionPackName(String questionPackName) {
        this.questionPackName = questionPackName;
    }

    public int getQuestionPackNOQ() {
        return questionPackNOQ;
    }

    public void setQuestionPackNOQ(int questionPackNOQ) {
        this.questionPackNOQ = questionPackNOQ;
    }

    public int getQuestionPackNOU() {
        return questionPackNOU;
    }

    public void setQuestionPackNOU(int questionPackNOU) {
        this.questionPackNOU = questionPackNOU;
    }

    public List<UUID> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<UUID> questionsList) {
        this.questionsList = questionsList;
    }

    public List<UUID> getExamsList() {
        return examsList;
    }

    public void setExamsList(List<UUID> examsList) {
        this.examsList = examsList;
    }
}

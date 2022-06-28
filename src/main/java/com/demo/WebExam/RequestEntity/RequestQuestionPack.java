package com.demo.WebExam.RequestEntity;

import com.demo.WebExam.Entity.Exam;
import com.demo.WebExam.Entity.Questions;

import java.util.HashSet;
import java.util.Set;

public class RequestQuestionPack {
    private String questionPackName;
    private int questionPackNOQ;
    private int questionPackNOU;
    private Set<Questions> Questions = new HashSet<>();
    private Set<Exam> Exams = new HashSet<>();

    public RequestQuestionPack(String questionPackName, int questionPackNOQ, int questionPackNOU, Set<com.demo.WebExam.Entity.Questions> questions, Set<Exam> exams) {
        this.questionPackName = questionPackName;
        this.questionPackNOQ = questionPackNOQ;
        this.questionPackNOU = questionPackNOU;
        Questions = questions;
        Exams = exams;
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

    public Set<com.demo.WebExam.Entity.Questions> getQuestions() {
        return Questions;
    }

    public void setQuestions(Set<com.demo.WebExam.Entity.Questions> questions) {
        Questions = questions;
    }

    public Set<Exam> getExams() {
        return Exams;
    }

    public void setExams(Set<Exam> exams) {
        Exams = exams;
    }
}

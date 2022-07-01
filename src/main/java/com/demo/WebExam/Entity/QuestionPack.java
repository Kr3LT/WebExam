package com.demo.WebExam.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "questionpack")
public class QuestionPack {
    @Id
    private UUID questionPackId = UUID.randomUUID();
    private String questionPackName;
    private int questionPackNOQ;
    private int questionPackNOU = 0;
    @OneToMany(mappedBy = "questionPackId",cascade = CascadeType.ALL)
    private Set<Questions> questions = new HashSet<>();
    @OneToMany(mappedBy = "questionPackId", cascade = CascadeType.ALL)
    private Set<Exam> exams = new HashSet<>();

    public QuestionPack(String questionPackName, int questionPackNOQ) {
        this.questionPackName = questionPackName;
        this.questionPackNOQ = questionPackNOQ;
    }

    public QuestionPack() {
    }

    public UUID getQuestionPackId() {
        return questionPackId;
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
        return questions;
    }

    public void setQuestions(Set<com.demo.WebExam.Entity.Questions> questions) {
        this.questions = questions;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
}

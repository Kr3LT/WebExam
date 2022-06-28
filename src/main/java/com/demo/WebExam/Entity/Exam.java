package com.demo.WebExam.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    private UUID examId = UUID.randomUUID();
    @Column
    private String examName;
    @Column
    private int examTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionPackId")
    private QuestionPack questionPackId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examCategoryId")
    private ExamCategory examCategoryId;

    public Exam(String examName, int examTime) {
        this.examId = UUID.randomUUID();
        this.examName = examName;
        this.examTime = examTime;
    }

    public Exam() {
    }

    public UUID getExamId() {
        return examId;
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

    public QuestionPack getQuestionPackId() {
        return questionPackId;
    }

    public void setQuestionPackId(QuestionPack questionPackId) {
        this.questionPackId = questionPackId;
    }

    public ExamCategory getExamCategoryId() {
        return examCategoryId;
    }

    public void setExamCategoryId(ExamCategory examCategoryId) {
        this.examCategoryId = examCategoryId;
    }
}

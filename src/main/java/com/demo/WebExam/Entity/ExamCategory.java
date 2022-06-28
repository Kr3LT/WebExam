package com.demo.WebExam.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "examcategory")
public class ExamCategory {
    @Id
    private UUID examCategoryId = UUID.randomUUID();
    @Column
    private String examCategoryName;
    @OneToMany(mappedBy = "examCategoryId",cascade = CascadeType.ALL)
    private Set<Exam> Exams = new HashSet<>();

    public ExamCategory(String examCategoryName) {
        this.examCategoryId = UUID.randomUUID();
        this.examCategoryName = examCategoryName;
    }

    public ExamCategory() {
    }

    public UUID getExamCategoryId() {
        return examCategoryId;
    }

    public String getExamCategoryName() {
        return examCategoryName;
    }

    public void setExamCategoryName(String examCategoryName) {
        this.examCategoryName = examCategoryName;
    }

    public Set<Exam> getExams() {
        return Exams;
    }

    public void setExams(Set<Exam> exams) {
        Exams = exams;
    }
}

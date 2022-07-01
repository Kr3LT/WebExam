package com.demo.WebExam.Entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class Questions {
    @Id
    private UUID questionId = UUID.randomUUID();
    @Column
    private String questionText;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionPackId")
    private QuestionPack questionPackId;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL)
    private Set<Answer> answers;

    public Questions(String questionText) {
        this.questionText = questionText;
    }

    public Questions(String questionText, QuestionPack questionPackId) {
        this.questionText = questionText;
        this.questionPackId = questionPackId;
    }

    public Questions() {
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionPack getQuestionPackId() {
        return questionPackId;
    }

    public void setQuestionPackId(QuestionPack questionPackId) {
        this.questionPackId = questionPackId;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}

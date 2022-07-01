package com.demo.WebExam.Repository;

import com.demo.WebExam.Entity.Answer;
import com.demo.WebExam.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, UUID> {

    @Query("SELECT t FROM Questions t WHERE t.questionPackId = ?1")
    List<Questions> findByQuestionPackId(UUID questionPackId);

}

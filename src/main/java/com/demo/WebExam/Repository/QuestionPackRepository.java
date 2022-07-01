package com.demo.WebExam.Repository;

import com.demo.WebExam.Entity.QuestionPack;
import com.demo.WebExam.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionPackRepository extends JpaRepository<QuestionPack, UUID> {

    Optional<QuestionPack> findByQuestions(UUID questionId);
}

package com.demo.WebExam.Repository;

import com.demo.WebExam.Entity.QuestionPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionPackRepository extends JpaRepository<QuestionPack, UUID> {
}

package com.demo.WebExam.Repository;

import com.demo.WebExam.Entity.ExamCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExamCategoryRepository extends JpaRepository<ExamCategory, UUID> {
}

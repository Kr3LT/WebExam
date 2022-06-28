package com.demo.WebExam.Repository;

import com.demo.WebExam.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamRepository extends JpaRepository<Exam, UUID> {

    List<Exam> findAllByExamCategoryId(UUID ExamCategoryId);
}

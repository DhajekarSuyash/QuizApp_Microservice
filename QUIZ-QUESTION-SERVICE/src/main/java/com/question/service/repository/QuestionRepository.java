package com.question.service.repository;

import com.question.service.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>
{

    @Query(value = "SELECT * FROM questions q WHERE q.category= :category ORDER BY RAND() LIMIT :noOfQuestions ",nativeQuery = true)
    List<Questions> findRandomQuestions(@Param("noOfQuestions") int noOfQuestions , @Param("category") String category);
}

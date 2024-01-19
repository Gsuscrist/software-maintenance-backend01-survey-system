package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.entities.Answer;


import java.util.List;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "select * from answers where question_id =:questionId", nativeQuery = true)
    List<Answer> getAllFrom(Long questionId);
}

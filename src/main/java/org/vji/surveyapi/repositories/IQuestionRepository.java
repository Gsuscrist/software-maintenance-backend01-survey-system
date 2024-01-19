package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.entities.Question;

import java.util.Base64;
import java.util.List;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "select * from questions where survey_id =:surveyId", nativeQuery = true)
    List<Question> getAllFrom(Long surveyId);
}

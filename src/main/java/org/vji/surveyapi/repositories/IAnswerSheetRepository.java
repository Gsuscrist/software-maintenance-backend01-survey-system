package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.entities.Question;

import java.util.List;

@Repository
public interface IAnswerSheetRepository extends JpaRepository<AnswerSheet, Long> {

    @Query(value = "select * from answer_sheet where survey_id =:surveyId", nativeQuery = true)
    List<AnswerSheet> getAllFrom(Long surveyId);
}

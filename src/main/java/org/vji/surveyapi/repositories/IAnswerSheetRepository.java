package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.entities.AnswerSheet;

@Repository
public interface IAnswerSheetRepository extends JpaRepository<AnswerSheet, Long> {

}

package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.entities.Survey;

@Repository
public interface ISurveyRepository extends JpaRepository<Survey, Long> {

}

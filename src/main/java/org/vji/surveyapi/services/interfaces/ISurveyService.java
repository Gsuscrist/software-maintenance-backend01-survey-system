package org.vji.surveyapi.services.interfaces;

import org.vji.surveyapi.controllers.dtos.requests.CreateSurveyRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.entities.Survey;

import java.util.List;

public interface ISurveyService {
    BaseResponse get(Long id);

    BaseResponse create(CreateSurveyRequest surveyRequest);

    Survey getSurveyById(Long id);



}

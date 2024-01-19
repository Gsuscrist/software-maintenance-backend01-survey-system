package org.vji.surveyapi.services.interfaces;

import org.vji.surveyapi.controllers.dtos.requests.CreateAnswerRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.entities.Answer;
import org.vji.surveyapi.entities.Question;

import java.util.List;

public interface IAnswerService {

    BaseResponse get (Long id);

    BaseResponse getAllFrom(Long questionId);

    List<Answer> getAllOf(Long questionId);

    BaseResponse create(CreateAnswerRequest request);

    void delete(Long id);
}

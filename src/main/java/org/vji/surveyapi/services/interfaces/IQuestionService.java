package org.vji.surveyapi.services.interfaces;

import org.vji.surveyapi.controllers.dtos.requests.CreateQuestionRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetQuestionResponse;
import org.vji.surveyapi.entities.Question;

import java.util.List;

public interface IQuestionService {
    BaseResponse get (Long id);

    BaseResponse getAllFrom (Long surveyId);

    List<Question> getAllOf(Long surveyId);

    BaseResponse create (CreateQuestionRequest request);

    void delete(Long id);

    Question getById(Long id);


}

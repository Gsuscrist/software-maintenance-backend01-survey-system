package org.vji.surveyapi.services.interfaces;

import org.vji.surveyapi.controllers.dtos.requests.CreateResponseRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetResponseResponse;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.entities.Response;

import java.util.List;

public interface IResponseService {

    BaseResponse get(Long id);

    BaseResponse create(CreateResponseRequest request);

    BaseResponse response(CreateResponseRequest request);

    void delete(Long id);
}

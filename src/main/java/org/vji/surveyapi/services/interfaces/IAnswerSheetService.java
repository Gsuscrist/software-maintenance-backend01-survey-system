package org.vji.surveyapi.services.interfaces;

import org.vji.surveyapi.controllers.dtos.requests.CreateAnswerSheetRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.entities.AnswerSheet;

public interface IAnswerSheetService {

    BaseResponse get(Long id);

    BaseResponse create(CreateAnswerSheetRequest request);

    AnswerSheet getById(Long id);


}

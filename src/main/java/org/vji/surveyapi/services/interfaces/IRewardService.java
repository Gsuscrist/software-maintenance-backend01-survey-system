package org.vji.surveyapi.services.interfaces;

import org.vji.surveyapi.controllers.dtos.requests.CreateRewardRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.entities.Reward;

import java.util.List;

public interface IRewardService {

    BaseResponse get(Long id);
    BaseResponse create(CreateRewardRequest request);

    List<Reward> getAllFrom(Long surveyId);

    void delete (Long id);
}

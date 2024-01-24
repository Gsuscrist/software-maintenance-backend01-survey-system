package org.vji.surveyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vji.surveyapi.controllers.dtos.requests.CreateRewardRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetRewardResponse;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.entities.Reward;
import org.vji.surveyapi.entities.Survey;
import org.vji.surveyapi.repositories.IRewardRepository;
import org.vji.surveyapi.services.interfaces.IRewardService;
import org.vji.surveyapi.services.interfaces.ISurveyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardServiceImpl  implements IRewardService {

    @Autowired
    private IRewardRepository repository;

    @Autowired
    private ISurveyService surveyService;

    @Override
    public BaseResponse get(Long id) {
        GetRewardResponse response = from(id);
        return BaseResponse.builder()
                .data(response)
                .message("get reward")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateRewardRequest request) {
        Reward reward = from(request);
        return BaseResponse.builder()
                .data(from(repository.save(reward)))
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Reward> getAllFrom(Long surveyId){
        return new ArrayList<>(repository.getAllFrom(surveyId));
    }

    private Reward from(CreateRewardRequest request){
        Reward reward = new Reward();
        reward.setDescription(request.getDescription());
        reward.setReward_code(request.getReward_code());
        Survey survey = surveyService.getSurveyById(request.getSurveyId());
        reward.setSurvey(survey);
        return reward;
    }

    private GetRewardResponse from (Reward reward){
        GetRewardResponse response = new GetRewardResponse();
        response.setId(reward.getId());
        response.setReward_code(reward.getReward_code());
        response.setDescription(reward.getDescription());
        Survey survey = reward.getSurvey();
        response.setSurveyId(survey.getId());
        return response;
    }

    private GetRewardResponse from (Long id){
        return  from(repository.findById(id).orElseThrow(()->new RuntimeException("reward not found")));

    }
}

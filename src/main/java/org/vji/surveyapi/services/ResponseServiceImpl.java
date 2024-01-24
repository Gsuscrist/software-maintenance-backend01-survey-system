package org.vji.surveyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vji.surveyapi.controllers.dtos.requests.CreateResponseRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetResponseResponse;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.entities.Response;
import org.vji.surveyapi.entities.Reward;
import org.vji.surveyapi.entities.Survey;
import org.vji.surveyapi.repositories.IResponseRepository;
import org.vji.surveyapi.services.interfaces.IAnswerSheetService;
import org.vji.surveyapi.services.interfaces.IResponseService;
import org.vji.surveyapi.services.interfaces.IRewardService;
import org.vji.surveyapi.services.interfaces.ISurveyService;

import java.util.Arrays;
import java.util.List;

@Service
public class ResponseServiceImpl implements IResponseService {

    @Autowired
    private IResponseRepository repository;

    @Autowired
    private ISurveyService surveyService;

    @Autowired
    private IAnswerSheetService answerSheetService;

    @Autowired
    private IRewardService rewardService;

    @Override
    public BaseResponse get(Long id) {
        GetResponseResponse response = from(id);
        return BaseResponse.builder()
                .data(response)
                .message("response by id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateResponseRequest request) {
        Response response = from(request);
        return BaseResponse.builder()
                .data(from(repository.save(response)))
                .message("response created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse response(CreateResponseRequest request){
        Response response = repository.save(from(request));
        List<AnswerSheet> answerSheets = answerSheetService.getAllFrom(request.getSurveyId());
        List<Reward> rewards = rewardService.getAllFrom(request.getSurveyId());

        for (AnswerSheet answerSheet : answerSheets) {
            if (compareAnswers(Arrays.toString(request.getAnswers()), Arrays.toString(answerSheet.getAnswers()))){
                if(!rewards.isEmpty()){
                   Reward reward = rewards.get(0);
                    return BaseResponse.builder()
                            .data("reward description: "+ reward.getDescription() +" reward code: " + reward.getReward_code())
                            .message("Congrats, enjoy your reward")
                            .success(Boolean.TRUE)
                            .httpStatus(HttpStatus.OK)
                            .build();
                }
            };
        }

        return BaseResponse.builder()
                .data(from(response))
                .message("Thanks for the answers")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    private boolean compareAnswers(String response, String answers){
        return response.equals(answers);
    }


    private Response from(CreateResponseRequest request){
        Response response = new Response();
        response.setName(request.getName());
        response.setLastname(request.getLastname());
        response.setEmail(request.getEmail());
        response.setPhoneNumber(request.getPhoneNumber());
        response.setAnswers(request.getAnswers());
        response.setSurvey(surveyService.getSurveyById(request.getSurveyId()));

        return response;

    }

    private GetResponseResponse from(Response response){
        GetResponseResponse getResponseResponse = new GetResponseResponse();
        getResponseResponse.setId(response.getId());
        getResponseResponse.setName(response.getName());
        getResponseResponse.setLastname(response.getLastname());
        getResponseResponse.setEmail(response.getEmail());
        getResponseResponse.setPhoneNumber(response.getPhoneNumber());
        getResponseResponse.setAnswers(response.getAnswers());
        Survey survey = response.getSurvey();
        getResponseResponse.setSurveyId(survey.getId());

        return getResponseResponse;
    }

    private GetResponseResponse from(Long id){

        return from(repository.findById(id).orElseThrow(()->new RuntimeException("response not found")));
    }
}

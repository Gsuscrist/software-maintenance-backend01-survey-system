package org.vji.surveyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vji.surveyapi.controllers.dtos.requests.CreateSurveyRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetSurveyResponse;
import org.vji.surveyapi.controllers.dtos.responses.SurveyResponse;
import org.vji.surveyapi.entities.Answer;
import org.vji.surveyapi.entities.Question;
import org.vji.surveyapi.entities.Survey;
import org.vji.surveyapi.repositories.ISurveyRepository;
import org.vji.surveyapi.services.interfaces.IAnswerService;
import org.vji.surveyapi.services.interfaces.IQuestionService;
import org.vji.surveyapi.services.interfaces.ISurveyService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements ISurveyService {

    private final ISurveyRepository repository;



    public SurveyServiceImpl(ISurveyRepository repository) {
        this.repository = repository;
    }


    @Override
    public BaseResponse get(Long id) {
        GetSurveyResponse response = from(id);
        return BaseResponse.builder()
                .data(response)
                .message("Survey by id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }



    @Override
    public BaseResponse create(CreateSurveyRequest surveyRequest) {
        Survey survey= from(surveyRequest);
        return BaseResponse.builder()
                .data(from(repository.save(survey)))
                .message("Survey created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Survey getSurveyById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Survey does not exist"));
    }


    private Survey from(CreateSurveyRequest request){
        return new Survey();
    }


    private GetSurveyResponse from(Survey survey){
        GetSurveyResponse response = new GetSurveyResponse();
        response.setId(survey.getId());
        return response;
    }

    private GetSurveyResponse from(Long id){
        Survey survey = repository.findById(id).orElseThrow(()-> new RuntimeException("Survey does not exist"));
        return from(survey);

    }
}

package org.vji.surveyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vji.surveyapi.controllers.dtos.requests.CreateAnswerSheetRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetAnswerSheetResponse;
import org.vji.surveyapi.entities.Survey;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.repositories.IAnswerSheetRepository;
import org.vji.surveyapi.services.interfaces.IAnswerSheetService;
import org.vji.surveyapi.services.interfaces.ISurveyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerSheetImpl implements IAnswerSheetService {
    private final IAnswerSheetRepository repository;

    private final ISurveyService surveyService;

    public AnswerSheetImpl(IAnswerSheetRepository repository, ISurveyService surveyService) {
        this.repository = repository;
        this.surveyService = surveyService;
    }

    @Override
    public BaseResponse get(Long id) {
        GetAnswerSheetResponse response= from(id);
        return BaseResponse.builder()
                .data(response)
                .message("Answer sheet by id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateAnswerSheetRequest request) {
        AnswerSheet answerSheet = from(request);

        return BaseResponse.builder()
                .data(from(repository.save(answerSheet)))
                .message("Answer sheet created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }


    @Override
    public List<AnswerSheet> getAllFrom(Long surveyId){
        return new ArrayList<>(repository.getAllFrom(surveyId));
    }

    @Override
    public AnswerSheet getById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Answer sheet not found"));
    }

    private AnswerSheet from (CreateAnswerSheetRequest request){
        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setAnswers(request.getAnswers());
        answerSheet.setSurvey(surveyService.getSurveyById(request.getSurveyId()));
        return answerSheet;
    }

    private GetAnswerSheetResponse from(AnswerSheet answerSheet){
        GetAnswerSheetResponse response = new GetAnswerSheetResponse();
        response.setId(answerSheet.getId());
        response.setAnswers(answerSheet.getAnswers());
        Survey survey = answerSheet.getSurvey();
        response.setSurveyId(survey.getId());
        return response;
    }

    private GetAnswerSheetResponse from(Long id){
        AnswerSheet answerSheet = repository.findById(id).orElseThrow(()->new RuntimeException("answer sheet not found"));
        return from(answerSheet);
    }
}

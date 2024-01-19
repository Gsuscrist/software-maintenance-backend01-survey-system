package org.vji.surveyapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vji.surveyapi.controllers.dtos.requests.CreateSurveyRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.SurveyResponse;
import org.vji.surveyapi.entities.Answer;
import org.vji.surveyapi.entities.Question;
import org.vji.surveyapi.entities.Survey;
import org.vji.surveyapi.services.interfaces.IAnswerService;
import org.vji.surveyapi.services.interfaces.IQuestionService;
import org.vji.surveyapi.services.interfaces.ISurveyService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("survey")
public class SurveyController {
    private final ISurveyService service;

    public SurveyController(ISurveyService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){
        BaseResponse baseResponse = service.get(id);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PostMapping()
    public ResponseEntity<BaseResponse> create(@RequestBody CreateSurveyRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }


}

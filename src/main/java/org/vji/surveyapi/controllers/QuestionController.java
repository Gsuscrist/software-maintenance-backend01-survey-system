package org.vji.surveyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vji.surveyapi.controllers.dtos.requests.CreateQuestionRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.services.interfaces.IQuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    private final IQuestionService service;

    public QuestionController(IQuestionService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){
        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping("/of/{surveyId}")
    public ResponseEntity<BaseResponse> getSurvey(@PathVariable Long surveyId){
        BaseResponse baseResponse = service.getAllFrom(surveyId);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }


    @PostMapping()
    public ResponseEntity<BaseResponse> create(@RequestBody CreateQuestionRequest request){
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(Long id){
        service.delete(id);
    }
}

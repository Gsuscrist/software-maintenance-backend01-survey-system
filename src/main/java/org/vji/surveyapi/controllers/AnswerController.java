package org.vji.surveyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vji.surveyapi.controllers.dtos.requests.CreateAnswerRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.services.interfaces.IAnswerService;

@RestController
@RequestMapping("answer")
public class AnswerController {
    private final IAnswerService service;

    public AnswerController(IAnswerService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){
        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("/of/{id}")
    public  ResponseEntity<BaseResponse> getAnswersOf(@PathVariable Long id){
        BaseResponse baseResponse =service.getAllFrom(id);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PostMapping()
    public ResponseEntity<BaseResponse> create(@RequestBody CreateAnswerRequest request){
        BaseResponse baseResponse= service.create(request);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

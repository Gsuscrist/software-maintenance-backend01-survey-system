package org.vji.surveyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vji.surveyapi.controllers.dtos.requests.CreateAnswerSheetRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.services.interfaces.IAnswerSheetService;

@RestController
@RequestMapping("/answer-sheet")
public class AnswerSheetController {
    private final IAnswerSheetService answerSheetService;

    public AnswerSheetController(IAnswerSheetService answerSheetService) {
        this.answerSheetService = answerSheetService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){
        BaseResponse baseResponse = answerSheetService.get(id);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateAnswerSheetRequest request){
        BaseResponse baseResponse = answerSheetService.create(request);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

}

package org.vji.surveyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vji.surveyapi.controllers.dtos.requests.CreateResponseRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.services.interfaces.IResponseService;

@RestController
@RequestMapping("response")
public class ResponseController {
    @Autowired
    private IResponseService service;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id){
        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PostMapping()
    public ResponseEntity<BaseResponse> create (@RequestBody CreateResponseRequest request){
        BaseResponse baseResponse = service.response(request);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

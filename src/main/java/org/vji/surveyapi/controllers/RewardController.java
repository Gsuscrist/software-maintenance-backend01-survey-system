package org.vji.surveyapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vji.surveyapi.controllers.dtos.requests.CreateRewardRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.services.interfaces.IRewardService;

@RestController
@RequestMapping("rewards")
public class RewardController {

    @Autowired
    private IRewardService rewardService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){
        BaseResponse baseResponse = rewardService.get(id);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateRewardRequest request){
        BaseResponse baseResponse = rewardService.create(request);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        rewardService.delete(id);
    }
}

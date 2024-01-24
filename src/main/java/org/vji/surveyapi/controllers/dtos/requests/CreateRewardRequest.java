package org.vji.surveyapi.controllers.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateRewardRequest {

    private String description;

    private String reward_code;

    private Long surveyId;
}

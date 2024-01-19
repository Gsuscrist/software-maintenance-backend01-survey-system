package org.vji.surveyapi.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAnswerRequest {

    private String answer;

    private  Character value;

    private Long questionId;
}

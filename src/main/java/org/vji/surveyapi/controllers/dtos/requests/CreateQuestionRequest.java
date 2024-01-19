package org.vji.surveyapi.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateQuestionRequest {

    private String question;

    private Long surveyId;
}

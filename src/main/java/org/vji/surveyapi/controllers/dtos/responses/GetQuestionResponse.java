package org.vji.surveyapi.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetQuestionResponse {

    private Long id;
    private String question;

    private Long surveyId;
}

package org.vji.surveyapi.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetAnswerResponse {
    private Long id;

    private String answer;

    private Character value;

    private Long questionId;
}

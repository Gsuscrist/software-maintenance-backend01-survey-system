package org.vji.surveyapi.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetAnswerSheetResponse {
    private Long id;

    private char[] answers;

    private Long surveyId;
}

package org.vji.surveyapi.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAnswerSheetRequest {

    private char[] answers;

    private Long surveyId;
}

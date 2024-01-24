package org.vji.surveyapi.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateResponseRequest {

    private  String name;

    private String lastname;

    private Long  phoneNumber;

    private String email;

    private char[] answers;

    private Long surveyId;
}

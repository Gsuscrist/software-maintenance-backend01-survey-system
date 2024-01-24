package org.vji.surveyapi.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetResponseResponse {
    private  Long id;

    private  String name;

    private String lastname;

    private Long  phoneNumber;

    private String email;

    private char[] answers;

    private Long surveyId;

}

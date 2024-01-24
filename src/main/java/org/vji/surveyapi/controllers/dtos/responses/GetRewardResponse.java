package org.vji.surveyapi.controllers.dtos.responses;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.vji.surveyapi.entities.Survey;


@Getter @Setter
public class GetRewardResponse {

    private Long id;

    private String description;

    private String reward_code;
    private Long surveyId;
}

package org.vji.surveyapi.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.vji.surveyapi.entities.Answer;
import org.vji.surveyapi.entities.Question;
import org.vji.surveyapi.entities.Survey;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class SurveyResponse {
    private Survey survey;

    private List<Question> questions;

    private Map<Long, List<Answer>> answers;

}

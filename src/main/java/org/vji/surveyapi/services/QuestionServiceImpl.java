package org.vji.surveyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vji.surveyapi.controllers.dtos.requests.CreateQuestionRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetQuestionResponse;
import org.vji.surveyapi.entities.Question;
import org.vji.surveyapi.entities.Survey;
import org.vji.surveyapi.repositories.IQuestionRepository;
import org.vji.surveyapi.services.interfaces.IQuestionService;
import org.vji.surveyapi.services.interfaces.ISurveyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionRepository repository;

    private final ISurveyService surveyService;

    public QuestionServiceImpl(IQuestionRepository repository, ISurveyService surveyService) {
        this.repository = repository;
        this.surveyService = surveyService;
    }

    @Override
    public BaseResponse get(Long id) {
        GetQuestionResponse response = from(id);

        return BaseResponse.builder()
                .data(response)
                .message("Question with id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllFrom(Long surveyId) {
        List<GetQuestionResponse> responses = repository
                .getAllFrom(surveyId)
                .stream().map(this::from)
                .collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("questions' list")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(CreateQuestionRequest request) {
        GetQuestionResponse response = from(repository.save(from(request)));

        return BaseResponse.builder()
                .data(response)
                .message("question created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public Question getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("question not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Question from(CreateQuestionRequest request){
        Question question = new Question();
        question.setQuestion(request.getQuestion());
        question.setSurvey(surveyService.getSurveyById(request.getSurveyId()));
        return question;

    }

    @Override
    public List<Question> getAllOf(Long surveyId) {
        return new ArrayList<>(repository.getAllFrom(surveyId));
    }

    private GetQuestionResponse from (Question question){
        GetQuestionResponse response = new GetQuestionResponse();
        response.setId(question.getId());
        response.setQuestion(question.getQuestion());
        Survey survey = question.getSurvey();
        response.setSurveyId(survey.getId());
        return response;
    }

    private GetQuestionResponse from (Long id){
        return from(repository.findById(id).orElseThrow(()->new RuntimeException("question not found")));
    }

}

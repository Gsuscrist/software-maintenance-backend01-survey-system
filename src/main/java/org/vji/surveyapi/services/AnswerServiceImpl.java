package org.vji.surveyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vji.surveyapi.controllers.dtos.requests.CreateAnswerRequest;
import org.vji.surveyapi.controllers.dtos.responses.BaseResponse;
import org.vji.surveyapi.controllers.dtos.responses.GetAnswerResponse;
import org.vji.surveyapi.entities.Answer;
import org.vji.surveyapi.entities.Question;
import org.vji.surveyapi.repositories.IAnswerRepository;
import org.vji.surveyapi.services.interfaces.IAnswerService;
import org.vji.surveyapi.services.interfaces.IQuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements IAnswerService {
    private final IAnswerRepository repository;

    private final IQuestionService questionService;

    public AnswerServiceImpl(IAnswerRepository repository, IQuestionService questionService) {
        this.repository = repository;
        this.questionService = questionService;
    }

    @Override
    public BaseResponse get(Long id) {
        GetAnswerResponse response = from(id);

        return BaseResponse.builder()
                .data(response)
                .message("Answer by id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllFrom(Long questionId) {
        List<GetAnswerResponse> responses = repository
                .getAllFrom(questionId)
                .stream().map(this::from)
                .collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("answers")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(CreateAnswerRequest request) {
        GetAnswerResponse response = from(repository.save(from(request)));

        return BaseResponse.builder()
                .data(response)
                .message("answer created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Answer> getAllOf(Long questionId) {
        return new ArrayList<>(repository.getAllFrom(questionId));
    }

    private Answer from (CreateAnswerRequest request){
        Answer answer = new Answer();
        answer.setAnswer(request.getAnswer());
        answer.setValue(request.getValue());
        answer.setQuestion(questionService.getById(request.getQuestionId()));
        return answer;
    }

    private GetAnswerResponse from (Answer answer){
        GetAnswerResponse response = new GetAnswerResponse();
        response.setId(answer.getId());
        response.setAnswer(answer.getAnswer());
        response.setValue(answer.getValue());
        Question question = answer.getQuestion();
        response.setQuestionId(question.getId());

        return response;
    }

    private GetAnswerResponse from(Long id){
        return from(repository.findById(id).orElseThrow(()-> new RuntimeException("answer not found")));
    }
}

package org.vji.surveyapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    //one survey to many question
    @OneToMany(mappedBy = "survey")
    private Set<Question> questions;

    //one survey to many rewards
    @OneToMany(mappedBy = "survey")
    private Set<Reward> rewards;

    @OneToMany(mappedBy = "survey")
    private Set<Response> responses;


    @OneToMany(mappedBy = "survey")
    private Set<AnswerSheet> answerSheet;
}

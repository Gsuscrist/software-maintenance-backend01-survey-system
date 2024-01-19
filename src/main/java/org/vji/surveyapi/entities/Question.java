package org.vji.surveyapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    //one question to many answers
    @OneToMany(mappedBy ="question")
    private Set<Answer> answers;

    //many question to one survey
    @ManyToOne
    private Survey survey;
}

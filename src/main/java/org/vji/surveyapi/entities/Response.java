package org.vji.surveyapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    private String lastname;

    private Long  phoneNumber;

    private String email;

    private char[] answers;


    @ManyToOne
    private Survey survey;
}

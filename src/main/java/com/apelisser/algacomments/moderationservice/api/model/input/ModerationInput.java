package com.apelisser.algacomments.moderationservice.api.model.input;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ModerationInput {

    private String commentId;
    private String text;

}

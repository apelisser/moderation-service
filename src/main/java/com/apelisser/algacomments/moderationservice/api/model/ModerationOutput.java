package com.apelisser.algacomments.moderationservice.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ModerationOutput {

    private boolean approved;
    private String reason;

}

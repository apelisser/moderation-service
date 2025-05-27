package com.apelisser.algacomments.moderationservice.api.mapper;

import com.apelisser.algacomments.moderationservice.api.model.ModerationOutput;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ModerationMapper {

    public ModerationOutput toApprovedOutput() {
        var output = new ModerationOutput();
        output.setApproved(true);
        output.setReason("There are no disallowed words in the text");
        return output;
    }

    public ModerationOutput toDisapprovedOutput(Set<String> disallowedWordsFound) {
        var output = new ModerationOutput();
        output.setApproved(false);
        output.setReason("Disallowed words found: " + disallowedWordsFound);
        return output;
    }

}

package com.apelisser.algacomments.moderationservice.api.controller;

import com.apelisser.algacomments.moderationservice.api.mapper.ModerationMapper;
import com.apelisser.algacomments.moderationservice.api.model.ModerationOutput;
import com.apelisser.algacomments.moderationservice.api.model.input.ModerationInput;
import com.apelisser.algacomments.moderationservice.domain.service.ModerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "/api/moderate", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModerationController {

    private final ModerationService moderationService;
    private final ModerationMapper moderationMapper;

    public ModerationController(ModerationService moderationService, ModerationMapper moderationMapper) {
        this.moderationService = moderationService;
        this.moderationMapper = moderationMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public ModerationOutput moderate(@RequestBody ModerationInput commentInput) {
        Set<String> disallowedWords = moderationService.extractDisallowedWords(commentInput.getText());

        if (!disallowedWords.isEmpty()) {
            log.warn("Disallowed words found in commentId {}: {}",
                commentInput.getCommentId(),
                disallowedWords);
            return moderationMapper.toDisapprovedOutput(disallowedWords);
        }
        return moderationMapper.toApprovedOutput();
    }


}

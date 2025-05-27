package com.apelisser.algacomments.moderationservice.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ModerationService {

    private static final Set<String> DISALLOWED_WORDS = Set.of("ódio", "xingamento");

    public Set<String> extractDisallowedWords(String text) {
        return DISALLOWED_WORDS.stream()
            .filter(text::contains)
            .collect(Collectors.toSet());
    }

}

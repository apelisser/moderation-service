package com.apelisser.algacomments.moderationservice.infrastructure.repository;

import com.apelisser.algacomments.moderationservice.domain.repository.DisallowedWordRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DisallowedWordInMemoryRepository implements DisallowedWordRepository {

    private static final Set<String> DISALLOWED_WORDS = Set.of("ódio", "xingamento");

    @Override
    public Set<String> getAllDisallowedWords() {
        return DISALLOWED_WORDS;
    }

}

package com.apelisser.algacomments.moderationservice.domain.service;

import com.apelisser.algacomments.moderationservice.domain.repository.DisallowedWordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ModerationService {

    private final DisallowedWordRepository disallowedWordRepository;

    public ModerationService(DisallowedWordRepository disallowedWordRepository) {
        this.disallowedWordRepository = disallowedWordRepository;
    }

    public Set<String> extractDisallowedWords(String text) {
        Set<String> disallowedWords = disallowedWordRepository.getAllDisallowedWords();

        return disallowedWords.stream()
            .filter(text::contains)
            .collect(Collectors.toSet());
    }

}

package com.apelisser.algacomments.moderationservice.domain.repository;

import java.util.Set;

public interface DisallowedWordRepository {

    Set<String> getAllDisallowedWords();

}

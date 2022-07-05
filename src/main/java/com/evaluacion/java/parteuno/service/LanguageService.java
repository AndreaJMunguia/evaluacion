package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.model.Language;
import java.util.List;

public interface LanguageService {

    Language createLanguage(Language language);

    Language updateLanguage(Language language);

    List<Language> getAllLanguages();

    Language getLanguageById(long languageId);

    void deleteLanguage(long id);
}

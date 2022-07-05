package com.evaluacion.java.parteuno.repository;

import com.evaluacion.java.parteuno.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}

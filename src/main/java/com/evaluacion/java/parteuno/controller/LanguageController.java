package com.evaluacion.java.parteuno.controller;

import com.evaluacion.java.parteuno.exception.Mensaje;
import com.evaluacion.java.parteuno.model.Language;
import com.evaluacion.java.parteuno.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/listalanguages")
    public ResponseEntity<?> getAllLanguage(){
        List<Language> lista = languageService.getAllLanguages();
        if(lista.isEmpty()) {
            return new ResponseEntity<>(new Mensaje("Sin languages en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(languageService.getAllLanguages());
    }

    @GetMapping("/detallelanguage/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable long id){
        return ResponseEntity.ok().body(languageService.getLanguageById(id));
    }

    @PostMapping("crearlanguage")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        return ResponseEntity.ok().body(this.languageService.createLanguage(language));
    }

    @PutMapping("actualizarlanguage/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language) {
        language.setId(id);
        return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
    }

    @DeleteMapping("eliminarlanguage/{id}")
    public HttpStatus deleteLanguage(@PathVariable long id) {
        this.languageService.deleteLanguage(id);
        return HttpStatus.OK;
    }
}

package com.atilas.genshin.controller;

import com.atilas.genshin.model.Characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atilas.genshin.repository.PersonagemInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/character")
public class PersonagemController {
    @Autowired
    private final PersonagemInterface personagemInterface;

    public PersonagemController(PersonagemInterface personagemInterface) {
        this.personagemInterface = personagemInterface;
    }

    @GetMapping
    public ResponseEntity<List<Characters>> list() {
        try {
            return new ResponseEntity<>(personagemInterface.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Characters> getOneCharacter(@PathVariable("id") Integer id) {
        try {
            Optional<Characters> character = personagemInterface.findById(id);
            if (character.isPresent()) {
                return new ResponseEntity<>(character.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> newCharacter(@RequestBody Characters traveller) {
        try {
            traveller.setId(personagemInterface.findAll().size());
            personagemInterface.save(traveller);
            return new ResponseEntity<>(traveller, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editCharacter(@PathVariable Integer id, @RequestBody Characters entity) {
        try {
            if (!personagemInterface.existsById(id)) {
                return new ResponseEntity<>(entity, HttpStatus.ACCEPTED);
            }
            entity.setId(id);
            personagemInterface.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable("id") Integer id) {
        try {
            Optional<Characters> character = personagemInterface.findById(id);
            if (character.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            personagemInterface.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

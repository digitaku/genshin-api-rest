package com.atilas.genshin.controller;

import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.CharactersBadRequest;
import com.atilas.genshin.exception.CharactersNotFoundException;
import com.atilas.genshin.model.Characters;

import com.atilas.genshin.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/character")
public class CharactersController {
    @Autowired
    private final CharactersService charactersService;

    public CharactersController(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping
    public ResponseEntity<List<Characters>> list() {
        try {
            return new ResponseEntity<>(charactersService.listAll(), HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Characters> getOneCharacter(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(charactersService.listOne(id), HttpStatus.OK);
        } catch (CharactersNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> newCharacter(@RequestBody Characters characters) {
        try {
            return new ResponseEntity<>(charactersService.add(characters), HttpStatus.CREATED);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editCharacter(@PathVariable Integer id, @RequestBody Characters entity) {
        try {
            return new ResponseEntity<>(charactersService.update(id, entity), HttpStatus.OK);
        } catch (CharactersNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (CharactersBadRequest e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable("id") Integer id) {
        try {
            charactersService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CharactersNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

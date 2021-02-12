package com.atilas.genshin.controller;

import com.atilas.genshin.model.Characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.atilas.genshin.repository.PersonagemInterface;

import java.util.List;

@RestController
@RequestMapping("api/character")
public class PersonagemController {
    @Autowired
    private PersonagemInterface personagemInterface;

    public PersonagemController(PersonagemInterface personagemInterface) {
        this.personagemInterface = personagemInterface;
    }

    @GetMapping
    public List<Characters> list() {
        try {
            return personagemInterface.findAll();
        } catch (Exception ex) {
            return List.of(new Characters());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Characters> getOneCharacter(@PathVariable("id") Integer id) {
        try {
            Characters character = personagemInterface.findById(id).get();
            if (character.getName() == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Characters> newCharacter(@RequestBody Characters characters) {
        try {
            if (characters == null) {
                throw new Exception("Cant complete");
            }
            personagemInterface.save(characters);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}

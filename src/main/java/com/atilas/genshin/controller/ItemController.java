package com.atilas.genshin.controller;

import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.CharactersBadRequest;
import com.atilas.genshin.exception.CharactersNotFoundException;
import com.atilas.genshin.model.Item;
import com.atilas.genshin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public ResponseEntity<List<Item>> list() {
        try {
            return new ResponseEntity<>(itemService.listAll(), HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getOneCharacter(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(itemService.listOne(id), HttpStatus.OK);
        } catch (CharactersNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> newCharacter(@RequestBody Item item) {
        try {
            return new ResponseEntity<>(itemService.add(item), HttpStatus.CREATED);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editCharacter(@PathVariable Integer id, @RequestBody Item item) {
        try {
            return new ResponseEntity<>(itemService.update(id, item), HttpStatus.OK);
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
            itemService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CharactersNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BusinessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

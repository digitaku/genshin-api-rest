package com.atilas.genshin.service;

import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.CharactersBadRequest;
import com.atilas.genshin.exception.CharactersNotFoundException;
import com.atilas.genshin.exception.ItemNotFoundException;
import com.atilas.genshin.model.Characters;
import com.atilas.genshin.repository.CharactersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CharactersService implements Serializable {
    @Autowired
    private final CharactersInterface charactersInterface;

    public CharactersService(CharactersInterface charactersInterface) {
        this.charactersInterface = charactersInterface;
    }

    public Characters add(Characters characters) {
        try {
            return charactersInterface.save(characters);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Characters> listAll() {
        try {
            return charactersInterface.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public Characters listOne(Integer id) {
        Optional<Characters> characters;
        try {
            characters = charactersInterface.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (characters.isEmpty()) {
            throw new CharactersNotFoundException("Character by id " + id + "was not found");
        }
        return characters.get();
    }

    public Characters update(Integer id, Characters characters) {

        if (!characters.getId().equals(id)) {
            throw new CharactersBadRequest(id + " And " + characters.getId() + "Don't Match");
        }
        Optional<Characters> optional;
        try {
            optional = charactersInterface.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        //not found
        if (optional.isEmpty()) {
            throw new CharactersNotFoundException("Character by id " + id + "was not found");
        }
        return charactersInterface.save(characters);
    }

    public void delete(Integer id) {
        //not found
        Optional<Characters> optional;
        try {
            optional = charactersInterface.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (optional.isEmpty()) {
            throw new CharactersNotFoundException("Character by id " + id + "was not found");
        }
        charactersInterface.deleteById(id);
    }

}

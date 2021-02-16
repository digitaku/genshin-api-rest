package com.atilas.genshin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atilas.genshin.model.Characters;

@Repository
public interface CharactersInterface extends JpaRepository<Characters, Integer> {

}

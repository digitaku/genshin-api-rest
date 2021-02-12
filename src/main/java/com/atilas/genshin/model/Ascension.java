package com.atilas.genshin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.Collection;

/**
 * Representa o necessário para a ascensão do personagem por level leveis
 * 20,40,50,60,70,80
 */
@Entity
public class Ascension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer level;
    private Integer mora;
    @ManyToMany()
    @JoinTable(name = "AscensionItems", joinColumns = @JoinColumn(name = "ascension_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Collection<Item> items;
}

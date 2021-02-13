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
    // um item em items possui um valor que não e fixo
    private Integer variableItem;
    // cada ascensão possui uma lista de item
    @ManyToMany()
    @JoinTable(name = "AscensionItems", joinColumns = @JoinColumn(name = "ascension_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Collection<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMora() {
        return mora;
    }

    public void setMora(Integer mora) {
        this.mora = mora;
    }

    public Integer getVariableItem() {
        return variableItem;
    }

    public void setVariableItem(Integer variableItem) {
        this.variableItem = variableItem;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

}

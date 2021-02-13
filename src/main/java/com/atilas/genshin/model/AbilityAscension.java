package com.atilas.genshin.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * representa o necessários para se fazer uma ascensão nos talentos de ação dos
 * personagens
 */
@Entity
public class AbilityAscension {
    // level,materials, mora cost
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer mora;
    private Integer level;

    @ManyToMany()
    @JoinTable(name = "AbilityAscensionItems", joinColumns = @JoinColumn(name = "ability_ascension_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Collection<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMora() {
        return mora;
    }

    public void setMora(Integer mora) {
        this.mora = mora;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}

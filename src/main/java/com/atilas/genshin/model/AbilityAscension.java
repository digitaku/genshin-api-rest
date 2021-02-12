package com.atilas.genshin.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * representa o necessarios para se fazer uma ascensão nos talentos de ação dos
 * personagens
 */
@Entity
public class AbilityAscension {
    // level,materials, mora cost
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer mora;

    @ManyToMany()
    @JoinTable(name = "AbilityAscensionItems", joinColumns = @JoinColumn(name = "ability_ascension_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Collection<Item> items;

    @OneToOne
    private ItemCount variableItem;
}

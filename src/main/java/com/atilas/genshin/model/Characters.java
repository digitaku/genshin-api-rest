package com.atilas.genshin.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Representa um personagem em genshin impact
 */
@Entity
public class Characters {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 50)
    private String allegiance;
    @Column(nullable = false)
    private int rarity;
    @Column(length = 30, nullable = false)
    private String weapon;
    @Column(length = 30, nullable = false)
    private String element;
    private Date birthDay;
    @Column(length = 50, nullable = false)
    private String astrolabeName;
    @Column(length = 250, nullable = false)
    private String description;
    @Column(nullable = false)
    private String imgUrl;

    // cada personagem possui muitos talentos
    @OneToMany()
    @JoinColumn(name = "Characters_id")
    private Collection<Talent> talents;

    @OneToMany()
    @JoinColumn(name = "Characters_id")
    private Collection<Ability> abilities;

    @OneToMany()
    @JoinColumn(name = "Characters_id")
    private Collection<Ascension> ascensions;

    @OneToMany()
    @JoinColumn(name = "Characters_id")
    private Collection<Stats> stats;

    // representa os items necessários para uma ascender as habilidades
    @OneToMany
    @JoinColumn(name = "Characters_id")
    private Collection<AbilityAscension> abilityAscensions;

    // construtor

    // Gets and Sets
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAstrolabeName() {
        return astrolabeName;
    }

    public void setAstrolabeName(String astrolabeName) {
        this.astrolabeName = astrolabeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Collection<Talent> getTalents() {
        return talents;
    }

    public void setTalents(Collection<Talent> talents) {
        this.talents = talents;
    }

    public Collection<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Collection<Ability> abilities) {
        this.abilities = abilities;
    }

    public Collection<Ascension> getAscensions() {
        return ascensions;
    }

    public void setAscensions(Collection<Ascension> ascensions) {
        this.ascensions = ascensions;
    }

    public Collection<Stats> getStats() {
        return stats;
    }

    public void setStats(Collection<Stats> stats) {
        this.stats = stats;
    }

    public Collection<AbilityAscension> getAbilityAscensions() {
        return abilityAscensions;
    }

    public void setAbilityAscensions(Collection<AbilityAscension> abilityAscensions) {
        this.abilityAscensions = abilityAscensions;
    }

}

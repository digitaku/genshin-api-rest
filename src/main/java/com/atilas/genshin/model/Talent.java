package com.atilas.genshin.model;

import java.util.Collection;

import javax.persistence.*;

/**
 * Representa um talento para personagens
 */
@Entity
public class Talent {
    // id, name, description
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 250, nullable = false)
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

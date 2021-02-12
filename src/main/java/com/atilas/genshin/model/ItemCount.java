package com.atilas.genshin.model;

import javax.persistence.*;

/**
 * represent a variable count in items for character ascension
 */
@Entity
public class ItemCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

package com.atilas.genshin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Representa a lista de status dos personagens e como eles podem aumentar
 * conforme o aumento da "ascensão" pode ser utilizado em uma collection em
 * Character
 */
@Entity
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer level;
    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer atkPercentage;
    private Integer criticalRate;
    private Integer criticalDamage;

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

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getAtkPercentage() {
        return atkPercentage;
    }

    public void setAtkPercentage(Integer atkPercentage) {
        this.atkPercentage = atkPercentage;
    }

    public Integer getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(Integer criticalRate) {
        this.criticalRate = criticalRate;
    }

    public Integer getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(Integer criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

}

package com.common.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@Entity
@Table(name="Category")
public class Category implements Serializable{

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cat_desc")
    private String cat_desc;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<Good> goods = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat_desc() {
        return cat_desc;
    }

    public void setCat_desc(String cat_desc) {
        this.cat_desc = cat_desc;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    public void addGood(Good good){
        this.goods.add(good);
    }
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cat_desc='" + cat_desc + '\'' +
                ", goods=" + goods +
                '}';
    }
}

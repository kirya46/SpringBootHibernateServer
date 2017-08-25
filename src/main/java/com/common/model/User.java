package com.common.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@Entity
@Table(name="\"User\"")
public class User {


    @Id
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

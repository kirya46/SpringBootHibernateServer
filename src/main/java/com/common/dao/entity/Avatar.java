package com.common.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@Entity
@Table(name="Avatar")
public class Avatar implements Serializable{

    @Id
    @Column(name="id", unique = true)
    private long id;

    @Column(name = "name")
    private String name;

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "\"device\"",inverseJoinColumns = @JoinColumn( name="id"))
//    @JoinColumn(name= "userid")
//    private Set<ADevice> devices;

//    public Set<ADevice> getDevices() {
//        return devices;
//    }
//
//    public void setDevices(Set<ADevice> devices) {
//        this.devices = devices;
//    }

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


    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", devices=" + devices +
                '}';
    }
}

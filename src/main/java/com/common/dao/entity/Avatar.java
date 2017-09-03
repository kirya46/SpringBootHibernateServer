package com.common.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@Entity
@Table(name="Avatar")
public class Avatar implements Serializable{

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */
@Entity
@Table(schema = "Device")
public class Device {
    @Id
    @Column(name="id")
    private int id;

}

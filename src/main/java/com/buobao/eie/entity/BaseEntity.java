package com.buobao.eie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by dqf on 2015/10/12.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    protected static final long serialVersionUID = -370316274269471219L;

    protected String id;

    @Id
    @Column(
            length = 32,
            nullable = false
    )
    @GeneratedValue(
            generator = "uuid"
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

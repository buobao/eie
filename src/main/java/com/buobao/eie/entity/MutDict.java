package com.buobao.eie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dqf on 2015/9/21.
 */
@Entity
@Table(name="sys_dict_my")
public class MutDict implements Serializable {
    private static final long serialVersionUID = -370316274269471212L;

    private String d_no;
    private String d_name;
    private MutDict d_parent;

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
    public String getD_no() {
        return d_no;
    }

    public void setD_no(String d_no) {
        this.d_no = d_no;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public MutDict getD_parent() {
        return d_parent;
    }

    public void setD_parent(MutDict d_parent) {
        this.d_parent = d_parent;
    }
}

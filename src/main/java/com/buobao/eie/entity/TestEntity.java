package com.buobao.eie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by dqf on 2015/9/21.
 */
@Entity
@Table(name = "test")
public class TestEntity implements Serializable{
    private static final long serialVersionUID = -370316274269471219L;

    private Integer id;
    private Integer sal;
    private String name;
    private String dep;

    //不指定构造器时会调用默认的构造器，所以定义自定义构造后需要申明无参构造
    public TestEntity(){}

    public TestEntity(Integer id, String name, Integer sal){
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
}

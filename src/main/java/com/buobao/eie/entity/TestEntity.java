package com.buobao.eie.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dqf on 2015/9/21.
 */
@Entity
@Table(name = "test")
public class TestEntity extends BaseEntity{
    protected static final long serialVersionUID = -370316274269471210L;

    private Integer sal;
    private String name;
    private String dep;

    //不指定构造器时会调用默认的构造器，所以定义自定义构造后需要申明无参构造
    public TestEntity(){}

    public TestEntity(String id, String name, Integer sal){
        this.id = id;
        this.name = name;
        this.sal = sal;
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

    @Override
    public String toString() {
        return "TestEntity{" +
                "id='" + id + '\'' +
                ", sal=" + sal +
                ", name='" + name + '\'' +
                ", dep='" + dep + '\'' +
                '}';
    }
}

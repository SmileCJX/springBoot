package com.caijx.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017/8/26/026.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 18,message = "未成年少女禁止入内")
    private Integer age;

    private String cupSize;

    public Girl() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
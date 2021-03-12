package com.derellea.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import java.io.Serializable;

public class Category implements Serializable {
    @Column(name = "cId")
    private int cId;
    @Column(name="cName")
    private String cName;
    @Column(name="cAdress")
    private String cAdress;
    @Column(name="cClass")
    private String cClass;

    public String getcClass() {
        return cClass;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass;
    }

    public String getcAdress() {
        return cAdress;
    }

    public void setcAdress(String cAdress) {
        this.cAdress = cAdress;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAdress='" + cAdress + '\'' +
                ", cClass='" + cClass + '\'' +
                '}';
    }
}

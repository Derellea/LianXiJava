package com.derellea.domain;


import javax.persistence.Column;
import java.io.Serializable;

public class Vedio implements Serializable {
    @Column(name = "vId")
    private int vId;
    @Column(name = "vcId")
    private int vcId;
    @Column(name = "vName")
    private String vName;
    @Column(name = "vAddress")
    private String vAddress;

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public int getVcId() {
        return vcId;
    }

    public void setVcId(int vcId) {
        this.vcId = vcId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    @Override
    public String toString() {
        return "Vedio{" +
                "vId=" + vId +
                ", vcId=" + vcId +
                ", vName='" + vName + '\'' +
                ", vAddress='" + vAddress + '\'' +
                '}';
    }
}

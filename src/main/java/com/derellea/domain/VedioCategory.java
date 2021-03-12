package com.derellea.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class VedioCategory implements Serializable {
    @Column(name = "vcID")
    private int vcId;
    @Column(name = "vcName")
    private String vcName;

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    public int getVcId() {
        return vcId;
    }

    public void setVcId(int vcId) {
        this.vcId = vcId;
    }

    @Override
    public String toString() {
        return "VedioCategory{" +
                "vcId=" + vcId +
                ", vcName='" + vcName + '\'' +
                '}';
    }
}

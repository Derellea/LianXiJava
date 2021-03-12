package com.derellea.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class Message implements Serializable {
    @Column(name = "sendId")
    private int sendId;
    @Column(name = "acceptId")
    private int acceptId;
    @Column(name = "ifread")
    private boolean ifread;

    public int getSendId() {
        return sendId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }

    public int getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(int acceptId) {
        this.acceptId = acceptId;
    }

    public boolean isIfread() {
        return ifread;
    }

    public void setIfread(boolean ifread) {
        this.ifread = ifread;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendId=" + sendId +
                ", acceptId=" + acceptId +
                ", ifread=" + ifread +
                '}';
    }
}

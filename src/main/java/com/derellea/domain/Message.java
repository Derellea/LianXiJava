package com.derellea.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {

    private int mId;

    private User send;

    private User accept;


    private boolean ifread;

    private String mDesc;

    private Timestamp mTime;


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public User getSend() {
        return send;
    }

    public void setSend(User send) {
        this.send = send;
    }

    public User getAccept() {
        return accept;
    }

    public void setAccept(User accept) {
        this.accept = accept;
    }

    public boolean isIfread() {
        return ifread;
    }

    public void setIfread(boolean ifread) {
        this.ifread = ifread;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public Timestamp getmTime() {
        return mTime;
    }

    public void setmTime(Timestamp mTime) {
        this.mTime = mTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mId=" + mId +
                ", sendId=" + send +
                ", acceptId=" + accept +
                ", ifread=" + ifread +
                ", mDesc='" + mDesc + '\'' +
                ", mTime=" + mTime +
                '}';
    }
}

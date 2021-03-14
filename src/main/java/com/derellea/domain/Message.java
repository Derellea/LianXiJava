package com.derellea.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
    @Column(name ="mId")
    private int mId;
    @Column(name = "sendId")
    private int sendId;
    @Column(name = "acceptId")
    private int acceptId;
    @Column(name = "ifRead")
    private boolean ifread;
    @Column(name = "mDesc")
    private String mDesc;
    @Column(name="mTime")
    private Timestamp mTime;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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
                "mId=" + mId +
                ", sendId=" + sendId +
                ", acceptId=" + acceptId +
                ", ifread=" + ifread +
                ", mDesc='" + mDesc + '\'' +
                ", mTime=" + mTime +
                '}';
    }
}

package com.derellea.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    @Column(name="uImage")
    private String uImage;//头像
    @Column(name="loginNum")
    private int loginNum;//登陆次数
    @Column(name="averageTime")
    private double averageTime;//每日平均观看视频时间
    @Column(name="vedioNum")
    private int vedioNum;//总共观看视频总数
    @Column(name="commentNum")
    private int commentNum;//总共评论次数
    @Column(name="lastVedio")
    private String lastVedio;//观看的最后一个视频
    private int active;//是否激活 1 激活 0 未激活
    private int code;// 激活码 uuid

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuImage() {
        return uImage;
    }

    public void setuImage(String uImage) {
        this.uImage = uImage;
    }

    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(int loginNum) {
        this.loginNum = loginNum;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }

    public int getVedioNum() {
        return vedioNum;
    }

    public void setVedioNum(int vedioNum) {
        this.vedioNum = vedioNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getLastVedio() {
        return lastVedio;
    }

    public void setLastVedio(String lastVedio) {
        this.lastVedio = lastVedio;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uImage='" + uImage + '\'' +
                ", loginNum=" + loginNum +
                ", averageTime=" + averageTime +
                ", vedioNum=" + vedioNum +
                ", commentNum=" + commentNum +
                ", lastVedio='" + lastVedio + '\'' +
                ", active=" + active +
                ", code=" + code +
                '}';
    }
}

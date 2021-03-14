package com.derellea.domain;


import javax.websocket.Session;
import java.io.Serializable;

public class OnlineUser implements Serializable {
    private String userid;
    private String nickname;
    private Session session;

    public OnlineUser(String userid, String nickname, Session session) {
        this.userid = userid;
        this.nickname = nickname;
        this.session = session;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "OnlineUser{" +
                "userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", session=" + session +
                '}';
    }
}

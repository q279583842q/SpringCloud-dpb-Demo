package com.dpb.springcloud_eureka_provider.pojo;

/**
 * @program: springcloud-eureka-provider
 * @description: UserBean
 * @author: 波波烤鸭
 * @create: 2019-05-28 17:31
 */
public class User {
    private int userid;
    private String username;
    private int userage;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public User(int userid, String username, int userage) {
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }

    public User() {
    }
}

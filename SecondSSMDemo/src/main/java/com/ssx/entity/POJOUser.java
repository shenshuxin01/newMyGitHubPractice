package com.ssx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("pojoUser")
public class POJOUser implements Serializable {
    private String password;
    private String name;

    public POJOUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public POJOUser() {
    }

    @Override
    public String toString() {
        return "POJOUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

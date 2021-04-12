package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String age;

    private SSX ssx;

    public User(String name, String age, SSX ssx) {
        this.name = name;
        this.age = age;
        this.ssx = ssx;
    }

    public SSX getSsx() {
        return ssx;
    }

    public void setSsx(SSX ssx) {
        this.ssx = ssx;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", ssx=" + ssx +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}

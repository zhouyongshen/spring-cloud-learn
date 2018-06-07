package com.zys.spring;

public class Member {
    String name;
    String age;
    String msg;

    public Member() {
    }

    public Member(String name, String age, String msg) {
        this.name = name;
        this.age = age;
        this.msg = msg;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

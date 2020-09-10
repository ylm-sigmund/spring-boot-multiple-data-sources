package com.diy.sigmund.springbootmultipledatasources.entity;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author ylm-sigmund
 * @since 2020/8/9 10:38
 */
public class StudentDO implements Serializable {

    private static final long serialVersionUID = 4108164792197012860L;
    private Integer userId;
    private String username;
    private Integer age;
    private Long phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentDO.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("username='" + username + "'")
                .add("age=" + age)
                .add("phone=" + phone)
                .toString();
    }
}

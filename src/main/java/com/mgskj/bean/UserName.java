package com.mgskj.bean;

import java.io.Serializable;
import java.util.Objects;

public class UserName implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(username, userName.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "UserName{" +
                "username='" + username + '\'' +
                '}';
    }
}

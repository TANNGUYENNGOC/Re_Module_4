package com.furama_management.model.user_role;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRole implements Serializable {
    @Column(name = "roleId")
    private int roleId;
    @Column(name = "username")
    private String username;

    public UserRole() {
    }

    public UserRole(int roleId, String username) {
        this.roleId = roleId;
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

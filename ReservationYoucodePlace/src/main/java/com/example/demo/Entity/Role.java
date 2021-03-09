package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id_r")
    private Integer idR;

    @Column(name = "Rolename")
    private String rolename;

    public Integer getIdR() {
        return this.idR;
    }

    public void setIdR(Integer idR) {
        this.idR = idR;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}

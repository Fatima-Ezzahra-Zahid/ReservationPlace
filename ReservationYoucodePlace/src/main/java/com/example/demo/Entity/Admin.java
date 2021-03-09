package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id_admin")
    private Integer idAdmin;

    @Column(name = "id_user")
    private Integer idUser;

    public Integer getIdAdmin() {
        return this.idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}

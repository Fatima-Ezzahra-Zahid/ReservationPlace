package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id_std")
    private Integer idStd;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "nbrMaxReserve")
    private Integer nbrMaxReserve;

    @Column(name = "is_accept")
    private Byte isAccept;

    public Integer getIdStd() {
        return this.idStd;
    }

    public void setIdStd(Integer idStd) {
        this.idStd = idStd;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getNbrMaxReserve() {
        return this.nbrMaxReserve;
    }

    public void setNbrMaxReserve(Integer nbrMaxReserve) {
        this.nbrMaxReserve = nbrMaxReserve;
    }

    public Byte getIsAccept() {
        return this.isAccept;
    }

    public void setIsAccept(Byte isAccept) {
        this.isAccept = isAccept;
    }
}

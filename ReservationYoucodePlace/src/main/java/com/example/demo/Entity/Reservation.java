package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "id_res")
    private Integer idRes;

    @Column(name = "dateResv")
    private java.sql.Date dateResv;

    @Column(name = "isAccept")
    private Byte isAccept;

    @Column(name = "id_st")
    private Integer idSt;

    @Column(name = "idtype")
    private Integer idtype;

    public Integer getIdRes() {
        return this.idRes;
    }

    public void setIdRes(Integer idRes) {
        this.idRes = idRes;
    }

    public java.sql.Date getDateResv() {
        return this.dateResv;
    }

    public void setDateResv(java.sql.Date dateResv) {
        this.dateResv = dateResv;
    }

    public Byte getIsAccept() {
        return this.isAccept;
    }

    public void setIsAccept(Byte isAccept) {
        this.isAccept = isAccept;
    }

    public Integer getIdSt() {
        return this.idSt;
    }

    public void setIdSt(Integer idSt) {
        this.idSt = idSt;
    }

    public Integer getIdtype() {
        return this.idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }
}

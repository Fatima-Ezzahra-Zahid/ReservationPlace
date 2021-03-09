package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "typereservation")
public class Typereservation {
    @Id
    @Column(name = "id_type")
    private Integer idType;

    @Column(name = "nbrPlace")
    private Integer nbrPlace;

    @Column(name = "typeRes")
    private String typeRes;

    public Integer getIdType() {
        return this.idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getNbrPlace() {
        return this.nbrPlace;
    }

    public void setNbrPlace(Integer nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getTypeRes() {
        return this.typeRes;
    }

    public void setTypeRes(String typeRes) {
        this.typeRes = typeRes;
    }
}

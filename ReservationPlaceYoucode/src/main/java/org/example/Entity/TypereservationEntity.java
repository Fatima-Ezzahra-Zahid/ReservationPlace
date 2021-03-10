package org.example.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "typereservation", schema = "reservation", catalog = "")
public class TypereservationEntity {
    private Long id;
    private int idType;
    private Integer nbrPlace;
    private String typeRes;
    private Collection<ReservationEntity> reservationsByIdType;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "nbrPlace")
    public Integer getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(Integer nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    @Basic
    @Column(name = "typeRes")
    public String getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(String typeRes) {
        this.typeRes = typeRes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypereservationEntity that = (TypereservationEntity) o;

        if (idType != that.idType) return false;
        if (nbrPlace != null ? !nbrPlace.equals(that.nbrPlace) : that.nbrPlace != null) return false;
        if (typeRes != null ? !typeRes.equals(that.typeRes) : that.typeRes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType;
        result = 31 * result + (nbrPlace != null ? nbrPlace.hashCode() : 0);
        result = 31 * result + (typeRes != null ? typeRes.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typereservationByIdtype")
    public Collection<ReservationEntity> getReservationsByIdType() {
        return reservationsByIdType;
    }

    public void setReservationsByIdType(Collection<ReservationEntity> reservationsByIdType) {
        this.reservationsByIdType = reservationsByIdType;
    }
}

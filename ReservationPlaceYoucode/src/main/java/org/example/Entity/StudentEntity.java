package org.example.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "student", schema = "reservation", catalog = "")
public class StudentEntity {
    private Long id;
    private int idStd;
    private Integer idUser;
    private Integer nbrMaxReserve;
    private Byte isAccept;
    private Collection<ReservationEntity> reservationsByIdStd;
    private UseradminEntity useradminByIdUser;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_std")
    public int getIdStd() {
        return idStd;
    }

    public void setIdStd(int idStd) {
        this.idStd = idStd;
    }

    @Basic
    @Column(name = "id_user")
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "nbrMaxReserve")
    public Integer getNbrMaxReserve() {
        return nbrMaxReserve;
    }

    public void setNbrMaxReserve(Integer nbrMaxReserve) {
        this.nbrMaxReserve = nbrMaxReserve;
    }

    @Basic
    @Column(name = "is_accept")
    public Byte getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(Byte isAccept) {
        this.isAccept = isAccept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (idStd != that.idStd) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        if (nbrMaxReserve != null ? !nbrMaxReserve.equals(that.nbrMaxReserve) : that.nbrMaxReserve != null)
            return false;
        if (isAccept != null ? !isAccept.equals(that.isAccept) : that.isAccept != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStd;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (nbrMaxReserve != null ? nbrMaxReserve.hashCode() : 0);
        result = 31 * result + (isAccept != null ? isAccept.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentByIdSt")
    public Collection<ReservationEntity> getReservationsByIdStd() {
        return reservationsByIdStd;
    }

    public void setReservationsByIdStd(Collection<ReservationEntity> reservationsByIdStd) {
        this.reservationsByIdStd = reservationsByIdStd;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public UseradminEntity getUseradminByIdUser() {
        return useradminByIdUser;
    }

    public void setUseradminByIdUser(UseradminEntity useradminByIdUser) {
        this.useradminByIdUser = useradminByIdUser;
    }
}

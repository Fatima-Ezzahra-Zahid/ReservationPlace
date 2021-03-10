package org.example.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservation", schema = "reservation", catalog = "")
public class ReservationEntity {
    private Long id;
    private int idRes;
    private Date dateResv;
    private Byte isAccept;
    private Integer idSt;
    private Integer idtype;
    private StudentEntity studentByIdSt;
    private TypereservationEntity typereservationByIdtype;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_res")
    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    @Basic
    @Column(name = "dateResv")
    public Date getDateResv() {
        return dateResv;
    }

    public void setDateResv(Date dateResv) {
        this.dateResv = dateResv;
    }

    @Basic
    @Column(name = "isAccept")
    public Byte getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(Byte isAccept) {
        this.isAccept = isAccept;
    }

    @Basic
    @Column(name = "id_st")
    public Integer getIdSt() {
        return idSt;
    }

    public void setIdSt(Integer idSt) {
        this.idSt = idSt;
    }

    @Basic
    @Column(name = "idtype")
    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (idRes != that.idRes) return false;
        if (dateResv != null ? !dateResv.equals(that.dateResv) : that.dateResv != null) return false;
        if (isAccept != null ? !isAccept.equals(that.isAccept) : that.isAccept != null) return false;
        if (idSt != null ? !idSt.equals(that.idSt) : that.idSt != null) return false;
        if (idtype != null ? !idtype.equals(that.idtype) : that.idtype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRes;
        result = 31 * result + (dateResv != null ? dateResv.hashCode() : 0);
        result = 31 * result + (isAccept != null ? isAccept.hashCode() : 0);
        result = 31 * result + (idSt != null ? idSt.hashCode() : 0);
        result = 31 * result + (idtype != null ? idtype.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_st", referencedColumnName = "id_std")
    public StudentEntity getStudentByIdSt() {
        return studentByIdSt;
    }

    public void setStudentByIdSt(StudentEntity studentByIdSt) {
        this.studentByIdSt = studentByIdSt;
    }

    @ManyToOne
    @JoinColumn(name = "idtype", referencedColumnName = "id_type")
    public TypereservationEntity getTypereservationByIdtype() {
        return typereservationByIdtype;
    }

    public void setTypereservationByIdtype(TypereservationEntity typereservationByIdtype) {
        this.typereservationByIdtype = typereservationByIdtype;
    }
}

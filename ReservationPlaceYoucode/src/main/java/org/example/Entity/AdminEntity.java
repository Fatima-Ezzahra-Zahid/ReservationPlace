package org.example.Entity;

import javax.persistence.*;

@Entity
@Table(name = "admin", schema = "reservation", catalog = "")
public class AdminEntity {
    private Long id;
    private int idAdmin;
    private Integer idUser;
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
    @Column(name = "id_admin")
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Basic
    @Column(name = "id_user")
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (idAdmin != that.idAdmin) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdmin;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        return result;
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

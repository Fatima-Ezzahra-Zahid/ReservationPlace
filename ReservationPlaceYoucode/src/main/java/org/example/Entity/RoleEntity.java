package org.example.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "reservation", catalog = "")
public class RoleEntity {
    private Long id;
    private int idR;
    private String rolename;
    private Collection<UseradminEntity> useradminsByIdR;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_r")
    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    @Basic
    @Column(name = "Rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (idR != that.idR) return false;
        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idR;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<UseradminEntity> getUseradminsByIdR() {
        return useradminsByIdR;
    }

    public void setUseradminsByIdR(Collection<UseradminEntity> useradminsByIdR) {
        this.useradminsByIdR = useradminsByIdR;
    }
}

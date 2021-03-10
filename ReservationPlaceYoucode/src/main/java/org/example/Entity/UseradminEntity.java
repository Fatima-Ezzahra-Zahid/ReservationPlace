package org.example.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "useradmin", schema = "reservation", catalog = "")
public class UseradminEntity {
    private Long id;
    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordUser;
    private Integer phoneNumber;
    private Integer idRole;
    private Collection<AdminEntity> adminsByIdUser;
    private Collection<StudentEntity> studentsByIdUser;
    private RoleEntity roleByIdRole;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "First_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "passwordUser")
    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Basic
    @Column(name = "phone_Number")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "id_role")
    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UseradminEntity that = (UseradminEntity) o;

        if (idUser != that.idUser) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passwordUser != null ? !passwordUser.equals(that.passwordUser) : that.passwordUser != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (idRole != null ? !idRole.equals(that.idRole) : that.idRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwordUser != null ? passwordUser.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (idRole != null ? idRole.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "useradminByIdUser")
    public Collection<AdminEntity> getAdminsByIdUser() {
        return adminsByIdUser;
    }

    public void setAdminsByIdUser(Collection<AdminEntity> adminsByIdUser) {
        this.adminsByIdUser = adminsByIdUser;
    }

    @OneToMany(mappedBy = "useradminByIdUser")
    public Collection<StudentEntity> getStudentsByIdUser() {
        return studentsByIdUser;
    }

    public void setStudentsByIdUser(Collection<StudentEntity> studentsByIdUser) {
        this.studentsByIdUser = studentsByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_r")
    public RoleEntity getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(RoleEntity roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}

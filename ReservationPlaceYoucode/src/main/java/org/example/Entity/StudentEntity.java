package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
//@PrimaryKeyJoinColumn(name = "studentId")
@Table(name = "student")
public class StudentEntity extends UseradminEntity implements Serializable {

    @Column(nullable = false)
    private int reservationMax;

    public int getReservationMax() {
        return reservationMax;
    }

    public void setReservationMax(int reservationMax) {
        this.reservationMax = reservationMax;
    }
}

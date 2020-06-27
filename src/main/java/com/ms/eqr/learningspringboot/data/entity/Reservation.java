package com.ms.eqr.learningspringboot.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;
    @Column(name="room_id")
    private long roomId;
    @Column(name="guest_id")
    private long guestId;
    @Column(name="reservation_date")
    private Date reservationDate;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", roomId=" + roomId +
                ", guestId=" + guestId +
                ", reservationDate=" + reservationDate +
                '}';
    }
}

package com.ms.eqr.learningspringboot.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "bed_info")
    private String bedInfo;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}

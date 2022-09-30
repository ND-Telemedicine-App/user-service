package com.team4.user_service;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
public class BusyTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long doctorId;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private String busyTime;

    @Column
    private int duration;

    public BusyTime() {
    }

    public BusyTime(Long id, Long doctorId, String busyTime, int duration) {
        this.id = id;
        this.doctorId = doctorId;
        this.busyTime = busyTime;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getBusyTime() {
        return busyTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setBusyTime(String busyTime) {
        this.busyTime = busyTime;
    }

    @Override
    public String toString() {
        return "AvailabilityTime{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", busyTime='" + busyTime + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}

package com.example.intern2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="airquality")
@Getter
@Setter
public class AirQuality {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    public Integer air_id;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getAir_id() {
        return air_id;
    }

    public void setAir_id(Integer air_id) {
        this.air_id = air_id;
    }

    public Integer getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(Integer airQuality) {
        this.airQuality = airQuality;
    }

    @Column
    public long timestamp;
    @Column
    public Integer airQuality;

    @ManyToOne
    @JoinColumn(name="poi_id")
    Poi poi_id;

    public Poi getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(Poi poi_id) {
        this.poi_id = poi_id;
    }
}
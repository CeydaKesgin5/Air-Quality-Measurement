package com.example.intern2.service;


import com.example.intern2.entity.AirQuality;

import java.time.LocalDateTime;
import java.util.List;

public interface IAirQualityService extends IService<AirQuality>
{
    public List<AirQuality> getMeasurement(int air_id, LocalDateTime timestamp, int airQuality);

    public default void deleteMeasurement(int id){
    }

    public default void updateMeasurement(int id, AirQuality airQuality){

    }
}
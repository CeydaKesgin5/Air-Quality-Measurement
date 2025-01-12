package com.example.intern2.repository;

import com.example.intern2.entity.AirQuality;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirQualityRepository extends JpaRepository<AirQuality,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AirQuality (air_id,timestamp, airQuality) VALUES (?air_id, ?timestamp, ?airQuality)", nativeQuery = true)
    void CreateMeasurement(@Param("air_id") int air_id, @Param("timestamp") float timestamp, @Param("airQuality") int airQuality);


    @Modifying
    @Transactional
    @Query("UPDATE AirQuality a SET a.timestamp = :timestamp, a.airQuality = :airQuality WHERE a.air_id = :air_id")
    void UpdateMeasurement(@Param("air_id") int air_id, @Param("timestamp") float timestamp, @Param("airQuality") float airQuality);


    @Query("DELETE FROM AirQuality a WHERE a.air_id = :air_id")
    void deleteByAirId(@Param("air_id") int air_id);

    @Query("SELECT a FROM AirQuality a WHERE a.air_id = :air_id")
    List<AirQuality> ListMeasurementById(@Param("air_id") int air_id);





}
package com.example.intern2.service.impl;


import com.example.intern2.common.GeneralException;
import com.example.intern2.entity.AirQuality;
import com.example.intern2.repository.IAirQualityRepository;
import com.example.intern2.service.IAirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AirQualityService implements IAirQualityService {

    @Autowired
    public IAirQualityRepository airQualityRepository;

    public AirQualityService(IAirQualityRepository airQualityRepository) {
        this.airQualityRepository = airQualityRepository;

    }

    @Override
    public AirQuality save(AirQuality airQuality) {
        return airQualityRepository.save(airQuality);
    }

    @Override
    public AirQuality getById(Integer id) {
        Optional<AirQuality> airQuality = airQualityRepository.findById(id);
        if(airQuality.isEmpty()){
            throw new GeneralException("Invalid not found!");
        }
        return airQuality.get();
    }

    @Override
    public List<AirQuality> getAll() {
        return airQualityRepository.findAll();    }



    @Override
    public void delete(Integer id) {
        if (!airQualityRepository.existsById(id)) {
            throw new GeneralException("Invalid not found!");
        }
        airQualityRepository.deleteById(id);
    }

    @Override
    public AirQuality update(Integer id,AirQuality updatedAirQuality) {
        AirQuality existingAirQuality=airQualityRepository.findById(id).orElseThrow(()
                -> new GeneralException("Invalid not found!"));

        existingAirQuality.setTimestamp(updatedAirQuality.getTimestamp());
        existingAirQuality.setAirQuality(updatedAirQuality.getAirQuality());
        return airQualityRepository.save(existingAirQuality);
    }

    @Override
    public void add() {
        airQualityRepository.save(new AirQuality());

    }

    @Override
    public List<AirQuality> getMeasurement(int air_id, LocalDateTime timestap, int airQuality) {
        return List.of();
    }

    @Override
    public void deleteMeasurement(int id) {
        IAirQualityService.super.deleteMeasurement(id);
    }

    @Override
    public void updateMeasurement(int id, AirQuality airQuality) {
        IAirQualityService.super.updateMeasurement(id, airQuality);
    }


}

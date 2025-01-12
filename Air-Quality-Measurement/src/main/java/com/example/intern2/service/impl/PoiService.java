package com.example.intern2.service.impl;


import com.example.intern2.common.GeneralException;
import com.example.intern2.entity.Poi;
import com.example.intern2.repository.IPoiRepository;
import com.example.intern2.service.IPoiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoiService implements IPoiService {
    public IPoiRepository poiRepository;

    public PoiService(IPoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    @Override
    public List<Poi> getPoisByLocation(float latitude, float longitude) {
        return List.of();
    }

    @Override
    public Poi save(Poi poi) {
        return poiRepository.save(poi);
    }
    @Override
    public Poi getById(Integer id) {
        Optional<Poi> poi = poiRepository.findById(id);
        if(poi.isEmpty()){
            throw new GeneralException("Invalid not found!");
        }
        return poi.get();    }

    @Override
    public List<Poi> getAll() {
        return poiRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (!poiRepository.existsById(id)) {
            throw new GeneralException("Invalid not found!");
        }
        poiRepository.deleteById(id);
    }

    @Override
    public Poi update(Integer id,Poi updatedPoi) {
        Poi existingPoi=poiRepository.findById(id).orElseThrow(()
                -> new GeneralException("Invalid not found!"));

        existingPoi.setDescription(updatedPoi.getDescription());
        existingPoi.setLatitude(updatedPoi.getLatitude());
        existingPoi.setLongitude(updatedPoi.getLongitude());
        return poiRepository.save(existingPoi);
    }

    @Override
    public void add() {
        poiRepository.save(new Poi());
    }
}
package com.example.intern2.service;

import com.example.intern2.entity.Poi;
import com.example.intern2.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPoiService extends IService<Poi> {



    public List<Poi> getPoisByLocation(float letitude, float latitude);

    public default void deletePoi(int id){}

    public default void updatePoi(int id, Poi poi){


    }
}

package com.example.intern2.controller;


import com.example.intern2.entity.Poi;
import com.example.intern2.service.IPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poi")

public class PoiController {

    private final IPoiService poiService;

    @Autowired
    public PoiController(IPoiService poiService) {
        this.poiService = poiService;
    }

    @GetMapping("/getAllPoi")
    public List<Poi> getAllPoi() {
        return poiService.getAll();
    }

    @GetMapping("/getPoi/{id}")
    public Poi getPoi(@PathVariable int id){
        return poiService.getById(id);
    }

    @GetMapping("/deletePoi/{id}")
    public void deletePoi(@PathVariable int id){
        poiService.delete(id);
    }

    @PutMapping("/updatePoi/{id}")
    public ResponseEntity<Poi> updatePoi(@PathVariable int id, @RequestBody Poi newPoiData){
        Poi updatedPoi = poiService.update(id, newPoiData);
        return ResponseEntity.ok(updatedPoi);
    }

    @PostMapping()
    public Poi savePoi(@RequestBody Poi poi) {
        Poi savedPoi = poiService.save(poi);
        return savedPoi;
    }
}

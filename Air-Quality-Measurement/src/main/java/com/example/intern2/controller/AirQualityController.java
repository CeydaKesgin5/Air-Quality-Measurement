
package com.example.intern2.controller;
import com.example.intern2.entity.AirQuality;
import com.example.intern2.service.IAirQualityService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/airquality")
public class AirQualityController {

    private final IAirQualityService airQualityService;

    public AirQualityController(IAirQualityService airQualityService) {
        this.airQualityService = airQualityService;
    }

    @GetMapping("/getAirQuality/{id}")
    public AirQuality getAirQuality(@PathVariable int id) {
        return airQualityService.getById(id);
    }

    @GetMapping("/getAll")
    public List<AirQuality> getAll(){
        return airQualityService.getAll();
    }

    @GetMapping("/deleteAirQuality/{id}")
    public void deleteAirQuality(@PathVariable int id){
        airQualityService.delete(id);
    }

    @PutMapping("/updateAirQuality/{id}")
    public ResponseEntity<AirQuality> updateAirQuality(@PathVariable int id, @RequestBody AirQuality newData){
        return ResponseEntity.ok(airQualityService.update(id, newData));
    }

    @PostMapping()
    public AirQuality saveAirQuality(@RequestBody AirQuality airQuality) {
        return airQualityService.save(airQuality);
    }
}


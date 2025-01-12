package com.example.intern2.database;

import com.example.intern2.entity.AirQuality;
import com.example.intern2.entity.Poi;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.influxdb.client.write.Point;

import java.time.Instant;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class InfluxDbConnection {
    private String token = "vokOW7TMPYSXddg59a6q_HVcr6sAuuHZrnRVI_s2lkT0Gvn2AkGWEYyRlvkEUTdBzqV5iCOMWjwcx51N-mMCeQ==";
    private String bucket = "MapMark";
    private String org = "MapMarking";
    private String url = "http://localhost:8086/";  // Only the base URL is needed here

    // Create InfluxDB client
    InfluxDBClient client = InfluxDBClientFactory.create(url, token.toCharArray(), org, bucket);
    WriteApiBlocking writeApi = client.getWriteApiBlocking();

    @PostMapping("/writePoint")
    public ResponseEntity<String> writePointbyPOJO(@RequestBody AirQuality data) {

        if (data == null) {
            return ResponseEntity.badRequest().body("Request body is missing");
        }

        try {
            Integer airId = data.getAir_id();
            Integer airQuality = data.getAirQuality();
            Poi poi = data.getPoi_id();
            Integer poiId = (poi != null) ? poi.getPoi_id() : null;


            if (airId == null || airQuality == null) {
                return ResponseEntity.badRequest().body("Air ID or Air Quality is missing");
            }

            // Create a point to write
            Point point = Point.measurement("test_measurement")
                    .addTag("air_id", airId.toString())
                    .addField("airQuality", airQuality)  // Assuming airQuality is numeric
                    .addField("poi_id", poiId)
                    .time(Instant.now(), WritePrecision.MS);

            // Write the point
            writeApi.writePoint(point);

            return ResponseEntity.ok("Data written successfully: Air ID " + airId + ", Air Quality " + airQuality);

        } catch (InfluxException e) {
            // Log the exception for debugging
            System.err.println("Exception occurred while writing data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error writing data: " + e.getMessage());
        }

    }


    @PostMapping("/writePointP2")
    public String writePointbyPOJO2() {

        Random random = new Random();
       int air_id = random.nextInt(10);

        int airQuality = random.nextInt(100);
        try {

            Point point = Point.measurement("measurement")
                    .addTag("air_id", Integer.toString(air_id))
                    .addField("airQuality",airQuality)

                    .time(Instant.now(), WritePrecision.MS);

            // Write the point
            writeApi.writePoint(point);
            return "Data written successfully";

        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
            return "Error writing data: No Data!"+ e.getMessage()+" "+ air_id+" "+airQuality+" ";
        }
    }


    @GetMapping("delete")
    public void Delete(){

    }


    @PostMapping("/writePointP")
    public String writePointbyPOJO() {

        try {
            // Create a point to write
            Point point = Point.measurement("test_measurement")
                    .addTag("air_id", "1")  // Removed the {$...} syntax which is incorrect
                    .addField("airQuality", "6")
                    .time(Instant.now(), WritePrecision.MS);

            // Write the point
            writeApi.writePoint(point);
            return "Data written successfully";

        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
            return "Error writing data: No Data!";
        }
    }
}
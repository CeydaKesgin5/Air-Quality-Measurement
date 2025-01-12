package com.example.intern2.repository;
import com.example.intern2.entity.Poi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IPoiRepository extends JpaRepository<Poi,Integer> {




        @Modifying
        @Query("UPDATE Poi p SET p.longitude = :longitude, p.latitude = :latitude, p.description = :description WHERE p.poi_id = :poi_id")
        void updatePoiByPoiId(@Param("poi_id") int poi_id, @Param("longitude") float longitude, @Param("latitude") float latitude, @Param("description") String description);

        @Query("SELECT p.poi_id FROM Poi p WHERE p.latitude = :latitude and  p.longitude = :longitude ")
        public int getPoisByLocation(float latitude, float longitude);


        @Query("SELECT p FROM Poi p WHERE p.poi_id = :poi_id")
        Poi findPoiByPoiId(@Param("poi_id") int poi_id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Poi (poi_id, latitude, longitude, description) VALUES (:poi_id, :latitude, :longitude, :description)", nativeQuery = true)
        void CreatePoi(@Param("poi_id") int poi_id, @Param("latitude") float latitude, @Param("longitude") float longitude, @Param("description") String description);

        @Modifying
        @Transactional
        @Query("DELETE FROM Poi p WHERE p.poi_id = :poi_id")
        void DeletePoiByPoiId(@Param("poi_id") int poi_id);


    }

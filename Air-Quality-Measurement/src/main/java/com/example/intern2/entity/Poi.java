package com.example.intern2.entity;
import com.example.intern2.entity.enums.PoiType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="poi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Poi {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer poi_id;
    @Column
    private float latitude;
    @Column
    private float longitude;
    @Column
    private String description;
    @Column
    @Enumerated(EnumType.STRING)
    private PoiType type;

}
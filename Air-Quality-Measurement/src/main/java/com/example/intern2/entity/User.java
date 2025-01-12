package com.example.intern2.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;

    @Column
    private String email;

    @Column
    public String password;

    @Column
    public String username;

    @ManyToOne
    @JoinColumn(name="poi_id")
    Poi poi_id;





}

package com.example.estiam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "VOITURE")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String color;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Passager> passagers;

    public Voiture() { this.passagers = new ArrayList<>(); }
    public Voiture(String nom, String color, Double price) { this.name = nom;
        this.color= color;
        this.price= price;
        this.passagers = new ArrayList<>();
    }


    public void addPassager(Passager passager) {
        passager.setVoiture(this);
        passagers.add(passager);
    }
    public List<Passager> getPassagers() { return passagers; }



}

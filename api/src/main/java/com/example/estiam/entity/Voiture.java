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

    private String categorie;
    private int nbr_Passager;

    private String image;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Passager> passagers;

    public Voiture() { this.passagers = new ArrayList<>(); }
    public Voiture(String nom, String color, Double price, String categorie, int nbr_Passager, String image) { this.name = nom;
        this.color= color;
        this.price= price;
        this.categorie=categorie;
        this.nbr_Passager=nbr_Passager;
        this.image=image;

        this.passagers = new ArrayList<>();
    }


    public void addPassager(Passager passager) {
        passager.setVoiture(this);
        passagers.add(passager);
    }
    public List<Passager> getPassagers() { return passagers; }



}

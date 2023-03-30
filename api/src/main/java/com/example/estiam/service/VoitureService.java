package com.example.estiam.service;

import com.example.estiam.entity.Voiture;

import java.util.List;

public interface VoitureService {
    List<Voiture> list();

    Voiture creer(Voiture voiture);

    String delete(Long id);

    Voiture update(Long id, Voiture voiture);
}

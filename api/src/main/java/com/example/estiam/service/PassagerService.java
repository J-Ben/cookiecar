package com.example.estiam.service;

import com.example.estiam.entity.Passager;

import java.util.List;

public interface PassagerService {
    List<Passager> list();

    Passager creer(Passager voiture);

    String delete(Long id);

    Passager update(Long id, Passager voiture);
}

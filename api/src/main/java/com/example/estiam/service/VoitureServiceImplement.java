package com.example.estiam.service;

import com.example.estiam.entity.Passager;
import com.example.estiam.entity.Voiture;
import com.example.estiam.repository.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VoitureServiceImplement implements VoitureService{
    private final VoitureRepository voitureRepository;
    @Override
    public List<Voiture> list() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture creer(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public String delete(Long id) {
        if(voitureRepository.findById(id).isEmpty()){
            return id+" no exists.";
        }
        voitureRepository.deleteById(id);
        return  "The car : "+id+" has been deleted.";
    }

    @Override
    public Voiture update(Long id, Voiture voiture) {
            return voitureRepository.findById(id).map((e)->{
            e.setName(voiture.getName());
            e.setColor(voiture.getColor());
            e.setPrice(voiture.getPrice());
            e.setCategorie(voiture.getCategorie());
            e.setImage(voiture.getImage());
            return voitureRepository.save(e);
            }).orElseThrow(()-> new RuntimeException("Car not found."));
    }


}

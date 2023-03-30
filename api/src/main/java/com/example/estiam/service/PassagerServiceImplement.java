package com.example.estiam.service;

import com.example.estiam.entity.Passager;
import com.example.estiam.entity.Voiture;
import com.example.estiam.repository.PassagerRepository;
import com.example.estiam.repository.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PassagerServiceImplement implements PassagerService{
    private final PassagerRepository passagerRepository;
    @Override
    public List<Passager> list() {
        return passagerRepository.findAll();
    }

    @Override
    public Passager creer(Passager passager) {
        return passagerRepository.save(passager);
    }

    @Override
    public String delete(Long id) {
        if(passagerRepository.findById(id).isEmpty()){
            return id+" no exists.";
        }
        passagerRepository.deleteById(id);
        return  "The car : "+id+" has been deleted.";
    }

    @Override
    public Passager update(Long id, Passager passager) {
        return passagerRepository.findById(id).map((e)->{
            e.setNom(passager.getNom());
            return passagerRepository.save(e);
        }).orElseThrow(()-> new RuntimeException("Car not found."));
    }
}

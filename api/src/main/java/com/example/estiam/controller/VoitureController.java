package com.example.estiam.controller;

import com.example.estiam.entity.Passager;
import com.example.estiam.entity.Voiture;
import com.example.estiam.repository.PassagerRepository;
import com.example.estiam.repository.VoitureRepository;
import com.example.estiam.service.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/voiture")
public class VoitureController {
    private final VoitureService voitureService;

    @Autowired
    private VoitureRepository voitureRepository;

    @CrossOrigin
    @GetMapping("/list")
    public List<Voiture> list(){
        return voitureService.list();
    }

    @PostMapping("/creer")
    public Voiture creer(@RequestBody Voiture voiture){
        return voitureService.creer(voiture);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return voitureService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Voiture update(@PathVariable Long id, @RequestBody Voiture voiture){
        return voitureService.update(id, voiture);
    }

    @GetMapping("/voiture-avec-passagers")
    public void ajouterVoitureAvecPassagers() {
        String tb[]={"Anna","Ariel","Aurore","Duchesse","Elsa","Jasmine","Megara","Perdita","Poca","hontas","Tiana","Anna","Ariel","Aurore","Duchesse","Elsa","Jasmine","Megara","Perdita","Poca","hontas"};
        Voiture voiture = new Voiture("Ford Mustang", "red", 10000.0,"2022 Cat",tb.length-1,"url_img");

        for(int i=1; i<tb.length;i++) {
            voiture.addPassager(new Passager(tb[i]));
        }
        voitureRepository.save(voiture);
    }



}

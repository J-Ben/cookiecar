package com.example.estiam.controller;

import com.example.estiam.entity.Passager;
import com.example.estiam.entity.Voiture;
import com.example.estiam.repository.PassagerRepository;
import com.example.estiam.repository.VoitureRepository;
import com.example.estiam.service.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/voiture")
public class VoitureController {
    private final VoitureService voitureService;

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


}

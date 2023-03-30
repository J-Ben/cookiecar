package com.example.estiam.controller;

import com.example.estiam.entity.Passager;
import com.example.estiam.entity.Voiture;
import com.example.estiam.service.PassagerService;
import com.example.estiam.service.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/passager")
public class PassagerController {
    private final PassagerService passagerService;
    @GetMapping("/list")
    public List<Passager> list(){
        return passagerService.list();
    }

    @PostMapping("/creer")
    public Passager creer(@RequestBody Passager passager){
        return passagerService.creer(passager);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return passagerService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Passager update(@PathVariable Long id, @RequestBody Passager passager){
        return passagerService.update(id, passager);
    }
}

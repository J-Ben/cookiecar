package com.example.estiam;

import com.example.estiam.entity.Passager;
import com.example.estiam.entity.Voiture;
import com.example.estiam.repository.PassagerRepository;
import com.example.estiam.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstiamApplication implements CommandLineRunner {

    @Autowired
    private VoitureRepository voitureRepository;



    public static void main(String[] args) {
        SpringApplication.run(EstiamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Voiture voiture = new Voiture("Ford Mustang", "red", 10000.0);
        String tb[]={"Anna","Ariel","Aurore","Duchesse","Elsa","Jasmine","Megara","Perdita","Poca","hontas","Tiana","Anna","Ariel","Aurore","Duchesse","Elsa","Jasmine","Megara","Perdita","Poca","hontas"};
        for(int i=1; i<tb.length;i++) {
            voiture.addPassager(new Passager(tb[i]));

        }
            voitureRepository.save(voiture);

    }
}

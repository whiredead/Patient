package com.example.tpthymleaf;

import com.example.tpthymleaf.Entity.Patient;
import com.example.tpthymleaf.Repository.PatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

public class TpThymleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpThymleafApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepo patientrepo){
        return args -> {
            patientrepo.save(new Patient(null,"el hachmy",new Date(),false,10));
            patientrepo.save(new Patient(null,"hassan",new Date(),true,20));
            patientrepo.save(new Patient(null,"hamza",new Date(),false,30));
            patientrepo.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}

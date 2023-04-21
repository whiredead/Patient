package com.example.tpthymleaf.web;

import com.example.tpthymleaf.Entity.Patient;
import com.example.tpthymleaf.Repository.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepo patientRepo;
    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "10") int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword
                            ){
        Page<Patient> pagePatients = patientRepo.findAll(PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patients.html";





    }

}

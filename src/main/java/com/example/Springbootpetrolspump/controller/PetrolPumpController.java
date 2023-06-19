package com.example.Springbootpetrolspump.controller;

import com.example.Springbootpetrolspump.model.PetrolPump;
import com.example.Springbootpetrolspump.service.PetrolPumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetrolPumpController {
    private final PetrolPumpService petrolPumpService;
    @Autowired
    public PetrolPumpController(PetrolPumpService petrolPumpService) {
        this.petrolPumpService = petrolPumpService;
    }
    @GetMapping("/")
    public String getAllPetrolPumps(Model model) {
        model.addAttribute("petrolPumps", petrolPumpService.getAllPetrolPumps());
        return "petrolPumps";
    }

    @GetMapping("/petrolPumps/{id}")
    public String getPetrolPumpById(@PathVariable Long id, Model model) {
        PetrolPump petrolPump = petrolPumpService.getPetrolPumpById(id);
        model.addAttribute("petrolPump", petrolPump);
        return "petrolPump";
    }

    @GetMapping("/petrolPumps/new")
    public String showPetrolPumpForm(Model model) {
        model.addAttribute("petrolPump", new PetrolPump());
        return "newPetrolPump";
    }

    @PostMapping("/petrolPumps")
    public String savePetrolPump(@ModelAttribute("petrolPump") PetrolPump petrolPump) {
        petrolPumpService.savePetrolPump(petrolPump);
        return "redirect:/";
    }

    @GetMapping("/petrolPumps/{id}/delete")
    public String deletePetrolPump(@PathVariable Long id) {
        petrolPumpService.deletePetrolPump(id);
        return "redirect:/";
    }
}

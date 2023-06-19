package com.example.Springbootpetrolspump.service;

import com.example.Springbootpetrolspump.model.PetrolPump;
import com.example.Springbootpetrolspump.repositroy.PetrolPumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetrolPumpService {
    private final PetrolPumpRepository petrolPumpRepository;

    @Autowired
    public PetrolPumpService(PetrolPumpRepository petrolPumpRepository) {
        this.petrolPumpRepository = petrolPumpRepository;
    }

    public List<PetrolPump> getAllPetrolPumps() {
        return petrolPumpRepository.findAll();
    }

    public PetrolPump getPetrolPumpById(Long id) {
        return petrolPumpRepository.findById(id).orElse(null);
    }

    public PetrolPump savePetrolPump(PetrolPump petrolPump) {
        return petrolPumpRepository.save(petrolPump);
    }

    public void deletePetrolPump(Long id) {
        petrolPumpRepository.deleteById(id);
    }
}

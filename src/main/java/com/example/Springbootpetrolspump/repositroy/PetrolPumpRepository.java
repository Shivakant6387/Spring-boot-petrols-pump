package com.example.Springbootpetrolspump.repositroy;

import com.example.Springbootpetrolspump.model.PetrolPump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetrolPumpRepository  extends JpaRepository<PetrolPump,Long> {
}

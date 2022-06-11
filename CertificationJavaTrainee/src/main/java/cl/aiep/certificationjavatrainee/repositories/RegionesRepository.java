package cl.aiep.certificationjavatrainee.repositories;

import cl.aiep.certificationjavatrainee.model.Regiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RegionesRepository extends JpaRepository<Regiones, Integer> {
}

package cl.aiep.certificationjavatrainee.repositories;

import cl.aiep.certificationjavatrainee.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}

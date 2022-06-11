package cl.aiep.certificationjavatrainee.repositories;

import cl.aiep.certificationjavatrainee.model.Curso;
import cl.aiep.certificationjavatrainee.model.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostulanteRepository extends JpaRepository<Postulante,Integer> {
    public Optional<Postulante>  findByRut (String rut);

    public List<Postulante> findByCurso(Curso curso);
}

package cl.aiep.certificationjavatrainee.repositories;

import cl.aiep.certificationjavatrainee.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador,Integer> {
    public Optional<Administrador> findByUsuario(String usuario);
}

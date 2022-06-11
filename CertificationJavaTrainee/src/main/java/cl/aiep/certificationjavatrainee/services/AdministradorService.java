package cl.aiep.certificationjavatrainee.services;

import cl.aiep.certificationjavatrainee.dao.AdministradorDao;
import cl.aiep.certificationjavatrainee.model.Administrador;
import cl.aiep.certificationjavatrainee.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements AdministradorDao {
    @Autowired
    private AdministradorRepository repo;

    @Override
    public Administrador AgregarAdministrador(Administrador administrador) {
        return repo.save(administrador);
    }

    @Override
    public void EliminarAdministrador(Integer id) {
        repo.deleteById(id);

    }

    @Override
    public Administrador BuscarAdministrador(Integer id) {
        return repo.getById(id);
    }
}

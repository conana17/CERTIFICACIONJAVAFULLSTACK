package cl.aiep.certificationjavatrainee.services;

import cl.aiep.certificationjavatrainee.dao.RegionesDao;
import cl.aiep.certificationjavatrainee.model.Regiones;
import cl.aiep.certificationjavatrainee.repositories.RegionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RegionesService implements RegionesDao {
    @Autowired
    public RegionesRepository repo;

    @Override
    public Regiones BuscarRegiones(Integer id) {
        return repo.getById(id);
    }

    @Override
    public List<Regiones> ListarRegiones() {
        return repo.findAll();
    }
}

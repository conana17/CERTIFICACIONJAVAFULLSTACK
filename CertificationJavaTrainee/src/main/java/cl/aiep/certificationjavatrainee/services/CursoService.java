package cl.aiep.certificationjavatrainee.services;

import cl.aiep.certificationjavatrainee.dao.CursoDao;
import cl.aiep.certificationjavatrainee.model.Curso;
import cl.aiep.certificationjavatrainee.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements CursoDao {

    @Autowired
    private CursoRepository repo;

    @Override
    public Curso AgregarCurso(Curso curso) {
        return repo.save(curso);
    }

    @Override
    public void EliminarCurso(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Curso BuscarCurso(Integer id) {
        return repo.getById(id);
    }

    @Override
    public void ActualizarCurso(Curso curso) {
        repo.save(curso);
    }

    @Override
    public List<Curso> ListarCursos() {
        return repo.findAll();
    }
}

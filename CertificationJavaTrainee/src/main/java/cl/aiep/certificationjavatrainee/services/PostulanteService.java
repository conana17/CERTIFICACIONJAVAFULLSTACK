package cl.aiep.certificationjavatrainee.services;

import cl.aiep.certificationjavatrainee.dao.PostulanteDao;
import cl.aiep.certificationjavatrainee.model.Curso;
import cl.aiep.certificationjavatrainee.model.Postulante;
import cl.aiep.certificationjavatrainee.repositories.CursoRepository;
import cl.aiep.certificationjavatrainee.repositories.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulanteService implements PostulanteDao{

    @Autowired
    private PostulanteRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private CursoRepository cursoRepository;

    @Override
    public List<Postulante> ListarPostulante() {
        return repo.findAll();
    }

    @Override
    public boolean agregarCurso(Integer id, Integer idCurso) {
        boolean retorno = true;
        try{
            Postulante post = repo.getById(id);
            Curso cur= cursoRepository.getById(idCurso);
            post.setCurso(cur);
            repo.save(post);
        }catch (Exception e){
            retorno = false;
        }
        return retorno;
    }

    @Override
    public Postulante actualizarPostulante(Postulante postulante) {
        return repo.save(postulante);
    }

    @Override
    public Postulante AgregarPostulante(Postulante postulante){
        String crypPassword = passwordEncoder.encode(postulante.getPassword());
        postulante.setPassword(crypPassword);
        return repo.save(postulante);
    }

    @Override
    public void EliminarPostulante(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Postulante BuscarPostulante(Integer id) {
        return repo.getById(id);
    }

}

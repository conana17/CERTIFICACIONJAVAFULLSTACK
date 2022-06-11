package cl.aiep.certificationjavatrainee.dao;

import cl.aiep.certificationjavatrainee.model.Curso;

import java.util.List;

public interface CursoDao {

    Curso AgregarCurso (Curso curso);
    void EliminarCurso (Integer  id);
    Curso BuscarCurso(Integer id);
    void ActualizarCurso (Curso curso);
    List<Curso> ListarCursos();
}

package cl.aiep.certificationjavatrainee.dao;

import cl.aiep.certificationjavatrainee.model.Postulante;

import java.util.List;

public interface PostulanteDao {
    Postulante AgregarPostulante(Postulante postulante);
    void EliminarPostulante(Integer id);
    Postulante BuscarPostulante(Integer id);
    List<Postulante> ListarPostulante();

    public boolean agregarCurso(Integer id, Integer idCurso);

    public Postulante actualizarPostulante(Postulante postulante);
}

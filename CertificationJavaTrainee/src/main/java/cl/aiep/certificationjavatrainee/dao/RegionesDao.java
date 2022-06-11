package cl.aiep.certificationjavatrainee.dao;

import cl.aiep.certificationjavatrainee.model.Regiones;

import java.util.List;

public interface RegionesDao {

    Regiones BuscarRegiones (Integer id);
    List<Regiones> ListarRegiones ();
}

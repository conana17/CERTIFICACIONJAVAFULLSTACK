package cl.aiep.certificationjavatrainee.dao;

import cl.aiep.certificationjavatrainee.model.Administrador;

public interface AdministradorDao {

    public Administrador AgregarAdministrador(Administrador administrador);
    public void EliminarAdministrador (Integer id);
    public Administrador BuscarAdministrador (Integer id);

}

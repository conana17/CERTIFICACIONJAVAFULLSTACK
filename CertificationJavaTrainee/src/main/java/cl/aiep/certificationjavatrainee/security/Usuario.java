package cl.aiep.certificationjavatrainee.security;

import cl.aiep.certificationjavatrainee.model.Administrador;
import cl.aiep.certificationjavatrainee.model.Postulante;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Usuario implements UserDetails {
    private static final long serialVersionUID = -1235958841231063510L;

    private Administrador administrador;

    private Postulante postulante;

    public Usuario(Administrador administrador, Postulante postulante){
        this.administrador = administrador;
        this.postulante = postulante;
    }
    public Administrador getAdministrador(){return administrador;}
    public Postulante getPostulante(){return postulante;}

    @Override
    public String getPassword(){
        if(postulante != null) return postulante.getPassword();
        if (administrador != null) return administrador.getPassword();
        return null;
    }
    @Override
    public String getUsername(){
        if(postulante != null) return postulante.getNombre();
        if (administrador != null) return administrador.getUsuario();
        return null;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if(postulante != null) return List.of(new SimpleGrantedAuthority("POSTULANTE"));
        if(administrador != null) return List.of(new SimpleGrantedAuthority("ADMINISTRADOR"));
        return null;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }


}

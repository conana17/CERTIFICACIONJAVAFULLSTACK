package cl.aiep.certificationjavatrainee.services;

import cl.aiep.certificationjavatrainee.model.Administrador;
import cl.aiep.certificationjavatrainee.model.Postulante;
import cl.aiep.certificationjavatrainee.repositories.AdministradorRepository;
import cl.aiep.certificationjavatrainee.repositories.PostulanteRepository;
import cl.aiep.certificationjavatrainee.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        Optional<Postulante> postulanteOpt = postulanteRepository.findByRut(username);
        if(postulanteOpt.isPresent()){
            return new Usuario(null,postulanteOpt.get());
        } else {
            Optional<Administrador> administradorOpt = administradorRepository.findByUsuario(username);
            if(administradorOpt.isPresent()){
                return new Usuario(administradorOpt.get(),null);
            }
        }
        throw new UsernameNotFoundException("Este Usuario no está registrado");

    }

}

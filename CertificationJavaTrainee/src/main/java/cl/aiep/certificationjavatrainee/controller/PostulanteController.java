package cl.aiep.certificationjavatrainee.controller;


import cl.aiep.certificationjavatrainee.dao.CursoDao;
import cl.aiep.certificationjavatrainee.dao.PostulanteDao;
import cl.aiep.certificationjavatrainee.dao.RegionesDao;
import cl.aiep.certificationjavatrainee.model.Curso;
import cl.aiep.certificationjavatrainee.model.Postulante;
import cl.aiep.certificationjavatrainee.security.Usuario;
import cl.aiep.certificationjavatrainee.services.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class PostulanteController {

    @Autowired
    private PostulanteService servicio;

    @Autowired
    private RegionesDao regionesDao;

    @Autowired
    private PostulanteDao postulanteDao;
    @Autowired
    private CursoDao cursoDao;

    @PostMapping("/postulante/registro")
    public String agregarPostulante(@Valid  Postulante postulante, BindingResult bindingResult, Model modelo){

        if(bindingResult.hasErrors()){
            modelo.addAttribute("region",regionesDao.ListarRegiones());
            return "views/registerform";
        }
        else{
            servicio.AgregarPostulante(postulante);
            return "views/login";
        }

    }

    @GetMapping("/postularCurso/{id}")
    @PreAuthorize("isAuthenticated()")
    public String agregarCurso(@PathVariable Integer id, Authentication authentication, Model modelo){
       Curso curso = cursoDao.BuscarCurso(id);
        if(authentication == null){
            return "views/login";
        }
        else {

            Usuario usuario = (Usuario) authentication.getPrincipal();
            Postulante postulante = postulanteDao.BuscarPostulante(usuario.getPostulante().getId());
            postulante.setCurso(curso);
            postulanteDao.actualizarPostulante(postulante);
            Integer disponibles = curso.getCuposIniciales() -1 ;
            curso.setCuposDisponibles(disponibles);
            cursoDao.ActualizarCurso(curso);
            modelo.addAttribute("curso",curso);

        }
        return "views/profileStudent";
    }

}

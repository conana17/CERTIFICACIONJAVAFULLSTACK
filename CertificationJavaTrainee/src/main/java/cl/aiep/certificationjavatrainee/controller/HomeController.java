package cl.aiep.certificationjavatrainee.controller;

import cl.aiep.certificationjavatrainee.dao.CursoDao;
import cl.aiep.certificationjavatrainee.dao.PostulanteDao;
import cl.aiep.certificationjavatrainee.dao.RegionesDao;
import cl.aiep.certificationjavatrainee.model.Curso;
import cl.aiep.certificationjavatrainee.model.Postulante;
import cl.aiep.certificationjavatrainee.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private RegionesDao regionesDao;

    @Autowired
    private CursoDao cursoDao;

    @Autowired
    private PostulanteDao postulanteDao;

    @GetMapping("/")
    public String index(){
        return "views/home";
    }


    @GetMapping("/postulante/registro")
    public String registro(Postulante postulante, Model modelo){
        modelo.addAttribute("postulante", postulante);
        modelo.addAttribute("regiones",regionesDao.ListarRegiones());
        return "views/registerform";
    }

    @GetMapping("/cursos")
    public String mostrarCursos(Model modelo){
        modelo.addAttribute("curso",cursoDao.ListarCursos());
        return "views/courses";
    }

    @GetMapping("/postulante/perfil")
    public String irPanel (Authentication usuarioAuth,Model modelo){
        Usuario usuario = (Usuario)  usuarioAuth.getPrincipal();
        Postulante postulante = postulanteDao.BuscarPostulante(usuario.getPostulante().getId());
        modelo.addAttribute("cursos", postulante.getCurso());
        return "views/profileStudent";
    }


}

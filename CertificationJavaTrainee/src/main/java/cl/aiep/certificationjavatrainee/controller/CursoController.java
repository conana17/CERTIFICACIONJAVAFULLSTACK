package cl.aiep.certificationjavatrainee.controller;

import cl.aiep.certificationjavatrainee.dao.AdministradorDao;
import cl.aiep.certificationjavatrainee.dao.CursoDao;
import cl.aiep.certificationjavatrainee.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CursoController {

    @Autowired
    private CursoDao cursoDao;

    @Autowired
    private AdministradorDao administradorDao;

    @GetMapping("/detalle-cursos/{id}")
    public String verDetalle(@PathVariable("id") Curso curso, Model modelo){

        modelo.addAttribute("curso",curso);
        return "views/coursedetails";
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/modificar-curso/{id}")
    public String editarCurso(@PathVariable("id") Integer idCurso, Model modelo){
        Curso curso = cursoDao.BuscarCurso(idCurso);
        modelo.addAttribute("curso", curso);
        return "/views/modifyCourseForm";
    }



    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/curso-crear")
    public String formularioCurso(Curso curso, Model modelo){
        modelo.addAttribute("curso",curso);
        return "/views/courseForm";
    }

    @PostMapping("/curso-crear")
    public String crearCurso(@Valid Curso curso, Model modelo){

            if(curso.getId()!=null) {
                cursoDao.ActualizarCurso(curso);
            }
            else {
                Integer cuposD = curso.getCuposIniciales();
                curso.setCuposDisponibles(cuposD);
                cursoDao.AgregarCurso(curso);
            }

            modelo.addAttribute( "curso",cursoDao.ListarCursos());
            return "/views/courses";


    }

    @GetMapping("/eliminar-curso/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public String eliminarCurso(@PathVariable Integer id){
        cursoDao.EliminarCurso(id);
        return "/views/courses";
    }

}

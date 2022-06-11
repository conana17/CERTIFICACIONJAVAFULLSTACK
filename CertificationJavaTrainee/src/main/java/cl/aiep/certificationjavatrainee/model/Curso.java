package cl.aiep.certificationjavatrainee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Curso {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Detalle", nullable = false, length = 345 )
    @NotNull(message = "Nombre del curso no debe ser vacío")
    private String descripcion;

    @Column(name = "Contenidos",nullable = false)
    @NotNull(message = "Contenidos no debe ser vacío")
    private String contenidos;

    @Column(name = "ImagenPortada", nullable = false)
    @NotNull(message = "Imagen no debe ser vacío")
    private String imagen;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Fecha de Inicio no debe ser vacío")
    private Date fechainicio;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Fecha de Termino no debe ser vacío")
    private Date fechafinal;

    @Column(name = "Cupos_iniciales", nullable = false)
    @Min(value=1, message = "Cupos no debe ser vacío")
    private Integer cuposIniciales;

    @Column(name = "Cupos_disponibles")
    private Integer cuposDisponibles;

    @OneToMany(mappedBy = "curso")
    private List<Postulante> postulantes;

}

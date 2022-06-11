package cl.aiep.certificationjavatrainee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter



public class Postulante {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false,length = 10)
    @NotEmpty(message = "Rut no puede ser vacio")
    @Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "RUT inválido")
    private String rut;

    @Column(name = "Nombre",nullable = false,length = 75)
    @NotEmpty (message = "nombre no puede ser vacio")
    private String nombre;

    @Column(name = "Apellido_1", nullable = false,length = 75)
    @NotEmpty (message = "Apellido1 no puede ser vacio")
    private String apellido1;

    @Column(name = "Apellido_2", nullable = false,length = 75)
    @NotEmpty (message = "Apellido2 no puede ser vacio")
    private String apellido2;

    @Column(name = "Telefono",nullable = false,length = 12)
    @NotEmpty (message = "telefono no puede ser vacio")
    private String telefono;

    @Column(name = "Direccion", nullable = false,length = 75)
    @NotEmpty (message = "direccion no puede ser vacio")
    private String direccion;

    @Column(name = "Email", nullable = false,length = 75)
    @NotEmpty (message = "E-mail no puede ser vacio")
    private String email;

    @Column(name = "Edad", nullable = false)
    @Min(value = 18, message = "No puedes postular si eres menor de edad")
    @Max(value = 99, message = "No puede ser mayor de 99 años")
    private Integer edad;

    @Column(name = "Password", nullable = false,length = 75)
    @NotEmpty(message = "password no puede ser vacio")
    private String password;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Regiones regiones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private Curso curso;



}

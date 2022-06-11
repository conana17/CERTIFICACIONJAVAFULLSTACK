package cl.aiep.certificationjavatrainee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Regiones {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "Descripcion", nullable = false, length = 70)
    private String descripcion;

    @OneToMany(mappedBy = "regiones")
    private List<Postulante> postulantes;
}

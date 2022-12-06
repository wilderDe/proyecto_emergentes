package emergentes.proyecto.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
@ToString @EqualsAndHashCode
public class Categoria {

    @Id
    @Getter @Setter @Column(name = "id")
    private int id;

    @Getter @Setter @Column(name = "nombre")
    private  String nombre;
}

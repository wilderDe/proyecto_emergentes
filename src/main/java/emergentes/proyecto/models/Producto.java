package emergentes.proyecto.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "productos")
@ToString @EqualsAndHashCode
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private int id;

    @Getter @Setter @Column(name = "categoria")
    private  int categoria;

    @Getter @Setter @Column(name = "descricpcion")
    private String descripcion;

    @Getter @Setter @Column(name = "cantidad")
    private String cantidad;

    @Getter @Setter @Column(name = "precio")
    private String precio;

}

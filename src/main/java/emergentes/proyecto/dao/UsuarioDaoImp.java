package emergentes.proyecto.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import emergentes.proyecto.models.Categoria;
import emergentes.proyecto.models.Producto;
import emergentes.proyecto.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import javax.persistence.EntityManager;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    private EntityManager entityManger;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManger.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManger.find(Usuario.class, id);
        entityManger.remove(usuario);
    }

    //REGISTRAR UN USUARIO
    @Override
    public void registrar(Usuario usuario) {
        //para guardar en la bd
        entityManger.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario){
        //String hacker = "' OR 1 = 1 --";
        //        String query = "FROM Usuario WHERE email ='"+usuario.getEmail()+"' AND password=''";
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManger.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }
        /*String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHashed, usuario.getPassword());*/
        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        }else{
            return null;
        }

    }
    // productos
    @Override
    public List<Producto> getProductos() {
        String query = "FROM Producto";
        return entityManger.createQuery(query).getResultList();
    }

    @Override
    public void setProducto(Producto producto) {
        //entityManger.merge(usuario);
        entityManger.merge(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        //Usuario usuario = entityManger.find(Usuario.class, id);
        //entityManger.remove(usuario);
        Producto producto = entityManger.find(Producto.class, id);
        entityManger.remove(producto);
    }


    //CATEGORIAS
    @Override
    public List<Categoria> getCategoria() {
        String query = "FROM Categoria";
        return  entityManger.createQuery(query).getResultList();
    }

    @Override
    public void setCategoria(Categoria categoria) {
        entityManger.merge(categoria);
    }
}

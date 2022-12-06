package emergentes.proyecto.dao;

import emergentes.proyecto.models.Categoria;
import emergentes.proyecto.models.Producto;
import emergentes.proyecto.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
    void eliminar(Long id);

    void registrar(Usuario usuario);
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);


    //PRODUCTOS

    List<Producto> getProductos();
    void setProducto(Producto producto);
    void eliminarProducto(int id);

    //CATEGORIAS

    List<Categoria> getCategoria();

    void setCategoria(Categoria categoria);

}

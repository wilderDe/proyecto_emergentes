package emergentes.proyecto.controllers;

import emergentes.proyecto.dao.UsuarioDao;
import emergentes.proyecto.models.Categoria;
import emergentes.proyecto.models.Producto;
import emergentes.proyecto.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Wilder");
        usuario.setApellido("Quispe");
        usuario.setEmail("wilder@gmail.com");
        usuario.setTelefono("78795808");

        return  usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        //asegurado la contraseña
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }



    //PRODUCTOS
    @RequestMapping(value = "api/productos", method = RequestMethod.GET)
    public List<Producto> getProducto(){
        return usuarioDao.getProductos();
    }


    @RequestMapping(value = "api/productos", method = RequestMethod.POST)
    public void registrarProducto(@RequestBody Producto producto){

        usuarioDao.setProducto(producto);
    }
    @RequestMapping(value = "api/productos/{id}", method = RequestMethod.DELETE)
    public void deleteProducto(@PathVariable int id){
        usuarioDao.eliminarProducto(id);
    }

    //CATEGORIA
    @RequestMapping(value = "api/categorias", method = RequestMethod.GET)
    public List<Categoria> getCategoria(){
        return usuarioDao.getCategoria();
    }


    @RequestMapping(value = "api/categorias", method = RequestMethod.POST)
    public void registrarCategoria(@RequestBody Categoria categoria){
        usuarioDao.setCategoria(categoria);
    }
}

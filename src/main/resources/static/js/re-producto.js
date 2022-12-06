


async function registrarProducto(){
    let datos = {};
    datos.descripcion = document.getElementById('txtDescripcion').value
    datos.cantidad = document.getElementById('txtCantidad').value
    datos.precio = document.getElementById('txtPrecio').value

    const request = await fetch('api/productos', {
        method: 'POST',
        headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    document.getElementById('txtDescripcion').value = "";
    document.getElementById('txtCantidad').value  = "";
    document.getElementById('txtPrecio').value = "";
    alert('Producto agregado con exito')

}














/*

PARA CARGAR
async function cargarUsuarios(){

  const request = await fetch('api/productos', {
    method: 'GET',
    headers: getHeaders
  });
  const productos = await request.json();
  let listadoHtml = '';

  for(let usuario of usuarios){
    let botonEliminar = '<a href="#" onClick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let telefono = usuario.telefono == null ? '-' : usuario.telefono;

    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'
     +usuario.email+'</td><td>'+telefono
     +'</td><td>'+botonEliminar+'</td></tr>';
    listadoHtml += usuarioHtml;
  }
  console.log(productos);
  //sdocument.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}
function getHeaders(){
    return {
       'Accept': 'application/json',
       'Content-Type': 'application/json',
       'Authorization': localStorage.token
    }
}

cargarUsuarios();*/
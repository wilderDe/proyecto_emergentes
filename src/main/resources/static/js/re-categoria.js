

async function registrarCategoria(){
    let datos = {};
    datos.id = document.getElementById('txtId').value
    datos.nombre = document.getElementById('txtNombre').value

    const request = await fetch('api/categorias', {
        method: 'POST',
        headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    document.getElementById('txtId').value = "";
    document.getElementById('txtNombre').value  = "";
    alert('Producto agregado con exito')
    console.log(datos);
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
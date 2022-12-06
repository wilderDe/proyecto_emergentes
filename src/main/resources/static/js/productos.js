
$(document).ready(function(){
    cargarProductos();
    $('#productos').DataTable();
})


async function cargarProductos(){


  const request = await fetch('api/productos', {
    method: 'GET',
    headers: getHeaders
  });
  const productos = await request.json()
  let listadoHtml = '';

  for(let producto of productos){
    let botonEliminar = '<a href="#" onClick="eliminarProducto('+producto.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let botonEditar = '<a href="#" onClick="editarProducto('+producto.id+')" class="btn btn-link btn-circle btn-sm"><i class="fas fa-edit"></i></a>';

    let productoHtml = '<tr><td>'+producto.id+'</td><td>'+producto.categoria+'</td><td>'+producto.descripcion+'</td><td> '+producto.cantidad+'</td><td>'
     +producto.precio+'</td><td>'+botonEliminar+' '+botonEditar   +'</td></tr>';
    listadoHtml += productoHtml;
  }
  console.log(productos);
  document.querySelector('#productos tbody').outerHTML = listadoHtml;
}

function getHeaders(){
    return {
       'Accept': 'application/json',
       'Content-Type': 'application/json',
       'Authorization': localStorage.token
    }
}
async function eliminarProducto(id){
    if(!confirm('¿Desea eliminar este producto?')){
        return;
    }
    const request = await fetch('api/productos/'+id, {
        method: 'DELETE',
        headers: getHeaders
    });

    location.reload();
}
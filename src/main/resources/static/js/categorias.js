$(document).ready(function(){
    cargarCategorias();
    $('#categorias').DataTable();
})

async function cargarCategorias(){
    const request = await fetch('api/categorias',{
        method: 'GET',
        headers: getHeaders
    })
    const categorias = await request.json()
    let listadoHtml = '';

    for(let categoria of categorias){
        let botonEliminar = '<a href="#" onClick="eliminarCategoria('+categoria.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let botonEditar = '<a href="#" onClick="editarProducto('+categoria.id+')" class="btn btn-link btn-circle btn-sm"><i class="fas fa-edit"></i></a>';

        let categoriaHtml = '<tr><td>'+categoria.id+'</td><td>'+categoria.nombre+'</td><td>'
            +botonEliminar+' '+botonEditar   +'</td></tr>';
        listadoHtml += categoriaHtml;
    }
    console.log(categorias);
    document.querySelector('#categorias tbody').outerHTML = listadoHtml;
}

function getHeaders(){
    return {
       'Accept': 'application/json',
       'Content-Type': 'application/json',
       'Authorization': localStorage.token
    }
}

async function eliminarCategoria(id){
    if(!confirm('¿Desea eliminar este producto?')){
        return;
    }
    const request = await fetch('api/categoria/'+id, {
        method: 'DELETE',
        headers: getHeaders
    });
    location.reload();
}
document.addEventListener("DOMContentLoaded", function () {
    cargarProyectos();
    $('#buscar').click(function () {
        buscarProyectos();
    });
    $('#proyectos').on('click', '.eliminar', function () {
        let id = $(this).attr('data-id');
        eliminarProyecto(id);
    });
});

async function cargarProyectos() {
    const request = await fetch('/listarProyectos', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    let proyectos = await request.json();
    // Comprobar que proyectos es un iterable y si no lo es, convertirlo en uno
    if (!proyectos[Symbol.iterator]) {
        proyectos = [proyectos];
    }
    let listadoHTML = '';
    for (let proyecto of proyectos) {
        let proyectoHTML = '<tr>' +
            '<th scope="row">' + proyecto.id + '</th>' +
            '<td>' + proyecto.nombre + '</td>' +
            '<td>' + proyecto.descripcion + '</td>' +
            "<td><button class='btn btn-primary actualizar' onclick='irEditar(" + proyecto.id + ")'>Actualizar</button> " +
            "<button class='btn btn-danger eliminar' onclick='eliminarProyecto(" + proyecto.id + ")'>Eliminar</button></td>" +
            '</tr>';
        listadoHTML += proyectoHTML;
    }
    document.querySelector('#proyectos tbody').outerHTML = listadoHTML;
}

async function eliminarProyecto(id) {
    const request = await fetch('/eliminarProyecto/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    let proyecto = await request.json();
    if (proyecto != null) {
        alert("Proyecto eliminado correctamente");
        window.location.href = "/proyectos";
    } else {
        alert("Error al eliminar el proyecto");
    }
}

async function buscarProyectos() {
    const request = await fetch('/buscar', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const proyectos = await request.json();
    let listadoHTML = '';
    for (let proyecto of proyectos) {
        let proyectoHTML = '<tr>' +
            '<th scope="row">' + proyecto.id + '</th>' +
            '<td>' + proyecto.nombre + '</td>' +
            '<td>' + proyecto.descripcion + '</td>' +
            "<td><button class='btn btn-primary actualizar' onclick='irEditar(" + proyecto.id + ")'>Actualizar</button> " +
            "<button class='btn btn-danger eliminar' onclick='eliminarProyecto(" + proyecto.id + ")'>Eliminar</button></td>" +
            '</tr>';
        listadoHTML += proyectoHTML;
    }
    document.querySelector('#proyectos tbody').outerHTML = listadoHTML;
}

async function irEditar(id) {
    window.location.href = "/actualizar.html?id=" + id;
}
$document.ready(function () {
    cargarProyectos();
    $('#buscar').click(function () {
        buscarProyectos();
    });
    $('#proyectos').on('click', '.actualizar', function () {
        let id = $(this).data('id');
        window.location.href = '/actualizar/' + id;
    });
    $('#proyectos').on('click', '.eliminar', function () {
        let id = $(this).data('id');
        eliminarProyecto(id);
    });
});

async function cargarProyectos() {
    const request = await fetch('/proyectos', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const proyectos = await request.json();
    let listadoHTML = '';
    for (let proyecto of proyectos) {
        let proyectoHTML = '<tr>' +
            '<th scope="row">' + proyecto.id + '</th>' +
            '<td>' + proyecto.nombre + '</td>' +
            '<td>' + proyecto.descripcion + '</td>' +
            '<td>' + proyecto.fechaInicio + '</td>' +
            '<td>' + proyecto.fechaFin + '</td>' +
            "<td><button class='btn btn-primary actualizar' data-id='" + proyecto.id + "'>Actualizar</button> " +
            "<button class='btn btn-danger eliminar' data-id='" + proyecto.id + "'>Eliminar</button></td>" +
            '</tr>';
        listadoHTML += proyectoHTML;
    }
    document.querySelector('#proyectos tbody').outerHTML = listadoHTML;
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
            '<td>' + proyecto.fechaInicio + '</td>' +
            '<td>' + proyecto.fechaFin + '</td>' +
            "<td><button class='btn btn-primary actualizar' data-id='" + proyecto.id + "'>Actualizar</button> " +
            "<button class='btn btn-danger eliminar' data-id='" + proyecto.id + "'>Eliminar</button></td>" +
            '</tr>';
        listadoHTML += proyectoHTML;
    }
    document.querySelector('#proyectos tbody').outerHTML = listadoHTML;
}
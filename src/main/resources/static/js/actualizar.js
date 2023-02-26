document.addEventListener("DOMContentLoaded", function () {
    let id = window.location.href.split("/")[4];
    cargarProyecto(id);
    // dale al boton actualizar la funcion actualizarProyecto
    document.querySelector('#actualizar').addEventListener('click', function () {
        actualizarProyecto(id);
    });
});

async function cargarProyecto(id) {
    const request = await fetch('/obtenerProyectoPorId/' + id, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    let proyecto = await request.json();
    document.querySelector('#nombre').value = proyecto.nombre;
    document.querySelector('#fechaInicio').value = proyecto.fechaInicio;
    document.querySelector('#fechaFin').value = proyecto.fechaFin;
    document.querySelector('#estado').value = proyecto.estado;
    document.querySelector('#descripcion').value = proyecto.descripcion;
}

async function actualizarProyecto(id) {
    let nombre = document.querySelector('#nombre').value;
    let fechaInicio = document.querySelector('#fechaInicio').value;
    let fechaFin = document.querySelector('#fechaFin').value;
    let estado = document.querySelector('#estado').value;
    let descripcion = document.querySelector('#descripcion').value;
    const request = await fetch('/actualizarProyecto/' + id, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre: nombre,
            fechaInicio: fechaInicio,
            fechaFin: fechaFin,
            estado: estado,
            descripcion: descripcion
        })
    });
    let proyecto = await request.json();
    if (proyecto != null) {
        alert("Proyecto actualizado correctamente");
        window.location.href = "/proyectos";
    } else {
        alert("Error al actualizar el proyecto");
    }
}
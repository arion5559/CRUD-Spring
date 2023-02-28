document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    cargarProyecto(id);
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
    document.querySelector('#descripcion').value = proyecto.descripcion;
}

async function actualizarProyecto() {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    let nombre = document.querySelector('#nombre').value;
    let descripcion = document.querySelector('#descripcion').value;

    // si fechafin no se ha introducido será null
    if (fechaFin == " 00:00:00") {
        fechaFin = null;
    }
    const request = await fetch('/actualizarProyecto/' + id + '/' + nombre + '/' + descripcion, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    let proyecto = await request.json();
    if (proyecto != null) {
        alert("Proyecto actualizado correctamente");
        window.location.href = "../proyectos.html";
    } else {
        alert("Error al actualizar el proyecto");
    }
}
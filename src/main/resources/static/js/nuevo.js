async function guardar() {
    let datos = {
        nombre: document.querySelector('#nombre').value,
        fechaInicio: document.querySelector('#fechaInicio').value,
        fechaFin: document.querySelector('#fechaFin').value,
        descripcion: document.querySelector('#descripcion').value,
        estado: document.querySelector('#estado').value,
    };
    const request = await fetch('/guardar', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const response = await request.json();
    if (response.status === 'OK') {
        alert('Proyecto guardado correctamente');
        window.location.href = '/proyectos';
    } else {
        alert('Error al guardar el proyecto');
    }
}
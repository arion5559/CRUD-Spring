async function guardar() {
    const nombre = document.getElementById('nombre').value;
    const descripcion = document.getElementById('descripcion').value;
    const request = await fetch(`/guardar/${nombre}/${descripcion}`, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    let proyecto = await request.json();
    if (proyecto != null) {
        alert("Proyecto guardado correctamente");
        window.location.href = "../proyectos.html";
    } else {
        alert("Error al guardar el proyecto");
    }
}
async function borrarPrestamo(id){
    console.log(id);
    await fetch('prestamos/id/'+id, {
        method: 'DELETE',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
    const filas = document.getElementById("tbody").rows.length;
    let i;
    for(i=0; i<filas;i++) {
        if (document.getElementById("tbody").rows[i].cells.item(0).innerText==id){
            document.getElementById("tbody").deleteRow(i);
        }
    }
}

async function actualizarPrestamo(id){
    console.log("actualizacion iniciada")
   let prestamo={};
   let filas = document.getElementById("tbody").rows.length;
   let i;

    let requestPrestamos;
    for(i=0; i<filas;i++) {
        if (document.getElementById("tbody").rows[i].cells.item(0).innerText==id){

            requestPrestamos = await fetch('prestamos/id/'+id, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            });


            prestamo= await requestPrestamos.json();
            console.log(prestamo)

            let tmp =document.getElementById("tbody").rows[i].cells.item(4).firstChild
            prestamo.fecha_prestamo=tmp.value;

            tmp =document.getElementById("tbody").rows[i].cells.item(5).firstChild
            prestamo.fecha_entrega=tmp.value;



        }
    }

    await fetch('prestamos', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(prestamo)
    });
}

async function buscarPrestamosCodEjemplar() {
    let codEjemplar = document.getElementById("bucador_codEjemplar").value;

    const requestPrestamos = await fetch('prestamos/codEjemplar/'+codEjemplar, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const prestamo = await requestPrestamos.json();

    let filas='';


        const boton_editar ='<button  type="button" class="btn btn-outline-secondary" onclick="actualizarPrestamo('+prestamo.id+')" >\n' +
            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">\n' +
            '<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>\n' +
            '<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>\n' +
            '</svg>\n' +
            '</button>';

    const boton_borrar ='<button type="button" class="btn btn-outline-secondary" onclick="borrarPrestamo('+prestamo.id+')">\n' +
        '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">\n' +
        '<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>\n' +
        '</svg>\n' +
        '</button>';

        const date_fechaPrestamo ='<input type="date" value='+prestamo.fecha_prestamo.slice(0,10)+'>'


        const date_fechaEntrega = '<input type="date" value='+prestamo.fecha_entrega.slice(0,10)+'>'

        filas+='<tr >' +
            '<td hidden>'+prestamo.id+'</td>\n' +
            '<td >'+prestamo.ejemplar.codigo+'</td>\n' +
            '<td >'+prestamo.ejemplar.libro.titulo+'</td>\n' +
            '<td >'+prestamo.usuario.nombre+" "+prestamo.usuario.apellidos+'</td>\n' +
            '<td  contenteditable=true>'+date_fechaPrestamo+'</td>\n' +
            '<td  contenteditable=true>'+date_fechaEntrega+'</td>\n' +
            '<td>' +
            '<div class="btn-group">\n' +
            boton_editar +
            boton_borrar +
            '</div>\n'+
            '</tr>';

         document.getElementById("tbody").innerHTML=filas;

}

async function BuscarPrestamosNumeroCarnet() {
    let nCarnet = document.getElementById("bucador_ncarnet").value;

    const requestPrestamos = await fetch('prestamos/nCarnet/'+nCarnet, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const prestamos = await requestPrestamos.json();


    let filas='';
    for(let prestamo of prestamos){
        console.log(prestamo.id)

        const boton_editar ='<button  type="button" class="btn btn-outline-secondary" onclick="actualizarPrestamo('+prestamo.id+')" >\n' +
            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">\n' +
            '<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>\n' +
            '<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>\n' +
            '</svg>\n' +
            '</button>';

        const boton_borrar ='<button type="button" class="btn btn-outline-secondary" onclick="borrarPrestamo('+prestamo.id+')">\n' +
            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">\n' +
            '<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>\n' +
            '</svg>\n' +
            '</button>';

        const date_fechaPrestamo ='<input type="date" value='+prestamo.fecha_prestamo.slice(0,10)+'>'


        const date_fechaEntrega = '<input type="date" value='+prestamo.fecha_entrega.slice(0,10)+'>'

        filas+='<tr >' +
            '<td hidden>'+prestamo.id+'</td>\n' +
            '<td >'+prestamo.ejemplar.codigo+'</td>\n' +
            '<td >'+prestamo.ejemplar.libro.titulo+'</td>\n' +
            '<td >'+prestamo.usuario.nombre+" "+prestamo.usuario.apellidos+'</td>\n' +
            '<td  contenteditable=true>'+date_fechaPrestamo+'</td>\n' +
            '<td  contenteditable=true>'+date_fechaEntrega+'</td>\n' +
            '<td>' +
            '<div class="btn-group">\n' +
            boton_editar +
            boton_borrar +
            '</div>\n'+
            '</tr>';
    }
    document.getElementById("tbody").innerHTML=filas;

}

async function createPrestamo(){

    let codEjemplar = document.getElementById("txt_create_ejemplar").value;
    let ncarnet = document.getElementById("txt_create_ncarnet").value;
    let fechaEntrega= document.getElementById("date_create_FechaEntrega").value;
    let fechaPrestamo = document.getElementById("date_create_FechaPrestamo").value;


    const requestUsuario = await fetch('usuarios/nCarnet/'+ncarnet, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuario = await requestUsuario.json();


    const requestEjemplar = await fetch('ejemplares/codEjempalar/'+codEjemplar, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const ejemplar = await requestEjemplar.json();


    let prestamo = {};
    prestamo.fecha_entrega = fechaEntrega;
    prestamo.fecha_prestamo = fechaPrestamo;
    prestamo.ejemplar = ejemplar;
    prestamo.usuario = usuario;



    await fetch('prestamos', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(prestamo)
    });

}






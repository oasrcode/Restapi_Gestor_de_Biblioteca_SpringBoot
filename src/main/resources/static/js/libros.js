async function borrarLibros(id) {
    const requestLibro =await fetch('libros/id/'+id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    if(requestLibro.ok){
        const filas = document.getElementById("tbody").rows.length;
        let i;
        for(i=0; i<filas;i++) {
            if (document.getElementById("tbody").rows[i].cells.item(0).innerText==id){
                document.getElementById("tbody").deleteRow(i);
            }
        }
    }else{
        if(requestLibro.status>=500){

            document.body.innerHTML += '<div class="alert">\n' +
                '  <span class="closebtn" onclick="this.parentElement.style.display=\'none\';">&times;</span> \n' +
                '  <p>No se puede Borrar, hay que borrar los ejemplares primero</p>' +
                '</div>';

        }
    }

}

async function actualizarLibros(id) {

    let libros={};
    let filas = document.getElementById("tbody").rows.length;
    let i;
    for(i=0; i<filas;i++) {
        if (document.getElementById("tbody").rows[i].cells.item(0).innerText==id){
            libros.id = id
            libros.titulo=document.getElementById("tbody").rows[i].cells.item(1).innerText;
            libros.autor=document.getElementById("tbody").rows[i].cells.item(2).innerText;
            libros.genero=document.getElementById("tbody").rows[i].cells.item(3).innerText;
            libros.editorial=document.getElementById("tbody").rows[i].cells.item(4).innerText;
            libros.isbn=document.getElementById("tbody").rows[i].cells.item(5).innerText;
        }
    }

    await fetch('libros', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(libros)
    });
}

async function crearLibro() {
    let libro={};
    libro.titulo=document.getElementById('txt_create_titulo').value;
    libro.autor=document.getElementById('txt_create_autor').value;
    libro.genero=document.getElementById('txt_create_genero').value;
    libro.editorial=document.getElementById('txt_create_editorial').value;
    libro.isbn=document.getElementById('txt_create_ISBN').value;

    await fetch('libros', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(libro)
    });
}


async function buscarLibroISBN() {
    let isbn = document.getElementById("bucador_isbn").value;
    const  requestLibro = await fetch("libros/ISBN/"+isbn,{
        method:"GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
    const  libro = await requestLibro.json();
    let filas='';

    const boton_editar ='<button  type="button" class="btn btn-outline-secondary" onclick="actualizarLibros(' + libro.id + ')" >\n' +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">\n' +
                '<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>\n' +
                '<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>\n' +
                '</svg>\n' +
                '</button>';

    const boton_borrar ='<button type="button" class="btn btn-outline-secondary" onclick="borrarLibros(' + libro.id + ')">\n' +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">\n' +
                '<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>\n' +
                '</svg>\n' +
                '</button>';

    filas+='<tr >' +
                '<td hidden>'+libro.id+'</td>\n' +
                '<td  contenteditable=true>'+libro.titulo+'</td>\n' +
                '<td  contenteditable=true>'+libro.autor+'</td>\n' +
                '<td  contenteditable=true>'+libro.genero+'</td>\n' +
                '<td  contenteditable=true>'+libro.editorial+'</td>\n' +
                '<td  contenteditable=true>'+libro.isbn+'</td>\n' +
                '<td>' +
                '<div class="btn-group">\n' +
                boton_editar +
                boton_borrar +
                '</div>\n'+
                '</tr>';
    document.getElementById("tbody").innerHTML=filas;
}

async function buscarLibroTitulo() {
    let titulo = document.getElementById("bucador_title").value;
    const  requestLibro = await fetch("libros/Title/"+titulo,{
        method:"GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
    const  libros = await requestLibro.json();
    let filas='';
    for (let libro of libros) {

        const boton_editar ='<button type="button" class="btn btn-outline-secondary" onclick="actualizarLibros(' + libro.id + ')" >\n' +
                    '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">\n' +
                    '<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>\n' +
                    '<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>\n' +
                    '</svg>\n' +
                    '</button>';

        const boton_borrar ='<button type="button" class="btn btn-outline-secondary" onclick="borrarLibros(' + libro.id + ')">\n' +
                    '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">\n' +
                    '<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>\n' +
                    '</svg>\n' +
                    '</button>';

        filas+='<tr >' +
                    '<td hidden>'+libro.id+'</td>\n' +
                    '<td  contenteditable=true>'+libro.titulo+'</td>\n' +
                    '<td  contenteditable=true>'+libro.autor+'</td>\n' +
                    '<td  contenteditable=true>'+libro.genero+'</td>\n' +
                    '<td  contenteditable=true>'+libro.editorial+'</td>\n' +
                    '<td  contenteditable=true>'+libro.isbn+'</td>\n' +
                    '<td>' +
                    '<div class="btn-group">\n' +
                    boton_editar +
                    boton_borrar +
                    '</div>\n'+
                    '</tr>';
            }
        document.getElementById("tbody").innerHTML=filas;
}
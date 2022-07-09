package com.oasr.biblioeca.Controlers;

import com.oasr.biblioeca.Modelos.Libros;
import com.oasr.biblioeca.Services.ILibrosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    ILibrosService iLibrosService;

    @GetMapping
    public List<Libros> BuscarTodos(){

        return  iLibrosService.BuscarTodos();
    }


    @GetMapping("id/{id}")
    public Libros BuscarID(@PathVariable("id") Long id){

        return iLibrosService.BuscarID(id);
    }

    @GetMapping("ISBN/{isbn}")
    public Libros BuscarPorISBN(@PathVariable("isbn") Long isbn){

        return iLibrosService.BuscarPorISBN(isbn);
    }

    @GetMapping("Title/{title}")
    public List<Libros>  BuscarPorTitulo(@PathVariable("title") String title){

        return iLibrosService.BuscarPorTitulo(title);
    }


    @PostMapping
    public void Crear(@RequestBody Libros libro) {

        iLibrosService.Guardar(libro);

    }


    @PutMapping
    public void Actualizar(@RequestBody Libros libro) {

        iLibrosService.Actualizar(libro);

    }

    @DeleteMapping("id/{id}")
    public void Borrar(@PathVariable("id")Long id){
        Libros libro = new Libros();
        libro = iLibrosService.BuscarID(id);
        if(libro==null){
            throw new RuntimeException("libro no encontrado -"+libro.getId());
        }else{
            iLibrosService.Borrar(libro);
        }

    }
}

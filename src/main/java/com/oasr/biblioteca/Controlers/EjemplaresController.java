package com.oasr.biblioteca.Controlers;

import com.oasr.biblioteca.Modelos.Ejemplares;
import com.oasr.biblioteca.Services.IEjemplaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejemplares")
public class EjemplaresController {

    @Autowired
    IEjemplaresService iEjemplaresService;


    @GetMapping
    public List<Ejemplares> BuscarTodos(){

        return iEjemplaresService.BuscarTodos();
    }


    @GetMapping("id/{id}")
    public Ejemplares BuscarID(@PathVariable("id") Long id){

        return iEjemplaresService.BuscarID(id);
    }


    @PostMapping
    public void Añadir(@RequestBody Ejemplares ejemplar) {

        iEjemplaresService.Guardar(ejemplar);

    }


    @PutMapping
    public void Actualizar(@RequestBody Ejemplares ejemplar) {

        iEjemplaresService.Actualizar(ejemplar);

    }

    @DeleteMapping("id/{id}")
    public void Borrar(@PathVariable("id")Long id){
        Ejemplares ejemplar = new Ejemplares();
        ejemplar = iEjemplaresService.BuscarID(id);
        if(ejemplar==null){
            throw new RuntimeException("Prestamo no encontrado -"+ejemplar.getId());
        }else{
            iEjemplaresService.Borrar(ejemplar);
        }

    }
    @GetMapping("isbn/{isbn}")
    public List<Ejemplares> BuscarPorISBN(@PathVariable("isbn")Long isbn){
        return iEjemplaresService.BuscarPorISBN(isbn);
    }

    @GetMapping("codEjempalar/{codEjempalar}")
    public Ejemplares BuscarPorCodigoEjemplar(@PathVariable("codEjempalar")String codEjempalar){
        return iEjemplaresService.BuscarPorCodigoEjemplar(codEjempalar);
    }


}

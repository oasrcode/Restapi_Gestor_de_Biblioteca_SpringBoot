package com.oasr.biblioteca.Controlers;




import com.oasr.biblioteca.Modelos.Prestamos;
import com.oasr.biblioteca.Services.IPrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

   @Autowired
    IPrestamosService iPrestamosService;

    @GetMapping
    public List<Prestamos> BuscarTodos(){

        return iPrestamosService.BuscarTodos();
    }


    @GetMapping("id/{id}")
    public Prestamos BuscarID(@PathVariable("id") Long id){

        return iPrestamosService.BuscarID(id);
    }


    @PostMapping
    public void Crear(@RequestBody Prestamos prestamo) {

        iPrestamosService.Guardar(prestamo);

    }


    @PutMapping
    public void Actualizar(@RequestBody Prestamos prestamo) {

        iPrestamosService.Actualizar(prestamo);

    }

    @DeleteMapping("id/{id}")
    public void Borrar(@PathVariable("id")Long id){
        Prestamos prestamo = new Prestamos();
        prestamo = iPrestamosService.BuscarID(id);
        if(prestamo==null){
            throw new RuntimeException("Prestamo no encontrado -"+prestamo.getId());
        }else{
            iPrestamosService.Borrar(prestamo);

        }

    }



    @GetMapping("nCarnet/{nCarnet}")
    public List<Prestamos> getByNCarnet(@PathVariable("nCarnet")Long nCarnet){
        return iPrestamosService.BuscarPorNumeroCarnet(nCarnet);
    }

    @GetMapping("codEjemplar/{codEjemplar}")
    public Prestamos getByCodEjemplar(@PathVariable("codEjemplar")String codEjemplar){
        return iPrestamosService.BuscarPorCodigoEjemplar(codEjemplar);
    }
}

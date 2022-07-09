package com.oasr.biblioteca.Controlers;

import com.oasr.biblioteca.Modelos.Usuarios;
import com.oasr.biblioteca.Services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService iUsuariosService;


    @GetMapping
    public List<Usuarios> BuscarTodosLosUsuarios(){

        return iUsuariosService.BuscarTodos();
    }

    @GetMapping("/id/{id}")
    public Usuarios BuscarUsuarioPorID(@PathVariable("id")Long id){

        return iUsuariosService.BuscarID(id);
    }
    @GetMapping("nCarnet/{nCarnet}")
    public Usuarios BuscarUsuarioPorNumeroCarnet(@PathVariable("nCarnet")Long nCarnet){

        return iUsuariosService.BuscarPorNumeroCarnet(nCarnet);
    }

    @GetMapping("/namesurn/{namesurn}")
    public List<Usuarios> BuscarUsuarioPorNomApe(@PathVariable("namesurn")String namesurn){

        return iUsuariosService.BuscarPorNomApel(namesurn);
    }


    @PostMapping
    public void Crear(@RequestBody Usuarios usuario) {
        iUsuariosService.Guardar(usuario);
    }

    @PutMapping
    public void Actualizar(@RequestBody Usuarios usuario) {

        iUsuariosService.Actualizar(usuario);

    }

    @DeleteMapping("id/{id}")
    public void Borrar(@PathVariable("id")Long id){
        Usuarios usuario = new Usuarios();
        usuario = iUsuariosService.BuscarID(id);
        if(usuario==null){
            throw new RuntimeException("Usuario no encontrado -"+usuario.getId());
        }else{
            iUsuariosService.Borrar(usuario);
        }

    }

}

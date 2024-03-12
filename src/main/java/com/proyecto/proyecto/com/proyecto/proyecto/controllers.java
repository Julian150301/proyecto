package com.proyecto.proyecto.com.proyecto.proyecto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.proyecto.proyecto.entity.Arrendador;
import com.proyecto.proyecto.repository.ArrendadorRepository;

import jakarta.persistence.criteria.From;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@SuppressWarnings("unused")
@Controller
public class controllers {
    private final ArrendadorRepository arrendadorRepository;

    @Autowired
    public controllers(ArrendadorRepository arrendadorRepository){
        this.arrendadorRepository = arrendadorRepository;
    }
    @GetMapping("/grupo13/home")
    public String home(){
        return "index.html";
    }
    
    @GetMapping("/grupo13/home/logingFormulario")
        public String showFormulario(){
            return "LogingFormulario.html";
        }
    @PostMapping("/grupo13/home/logingFormulario")
    public String prosLoging(@RequestParam("name") String nombre,
                            @RequestParam("apellidos") String apellidos,
                            @RequestParam("edad") String edad,
                            @RequestParam("correo")String correo,
                            @RequestParam("telefono")int telefono,
                            @RequestParam("contraseña")String contraseña,
                            @RequestParam("tipoCuenta")int tipoCuenta) {
            Arrendador arrendador=new Arrendador();
            arrendador.setNombre(nombre);
            arrendador.setApellidos(apellidos);
            arrendador.setEdad(tipoCuenta);
            arrendador.setCorreo(correo);
            arrendador.setTelefono(telefono);
            arrendador.setContraseña(contraseña);
            arrendador.setTipoCuenta(tipoCuenta);    
            
            arrendadorRepository.save(arrendador);
        
        return "redirect: /grupo13/home";
    }
    
}
    

    



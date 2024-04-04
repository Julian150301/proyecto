    package com.proyecto.proyecto.controllers;

    import org.springframework.web.bind.annotation.RestController;

    import com.proyecto.proyecto.dto.ArrendadorDTO;
    import com.proyecto.proyecto.repository.ArrendadorRepository;
    import com.proyecto.proyecto.services.ArrendadorService;

    import java.util.List;

    import javax.print.attribute.standard.Media;


    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.MediaType;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;




    @RestController
    @RequestMapping(value = "/grupo13/logingFormulario")
    public class ArrendadorController {
        ArrendadorService arrendadorService;
        @Autowired
        public ArrendadorController(ArrendadorService arrendadorService){
            this.arrendadorService = arrendadorService;
        }

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ArrendadorDTO get(@PathVariable Long id){
            return arrendadorService.get(id);
        }

        @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
        public List<ArrendadorDTO>get(){
            return arrendadorService.get();
        }

        @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
        public ArrendadorDTO save(@RequestBody ArrendadorDTO arrendadorDTO){
            return arrendadorService.save(arrendadorDTO);
        }

        @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE)
        public ArrendadorDTO update(@RequestBody ArrendadorDTO arrendadorDTO){
            return arrendadorService.update(arrendadorDTO);
        }

        @DeleteMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
        public void delete(@PathVariable Long id){
            arrendadorService.delete(id);
        }

    }

package com.example.empresapractica.Controller;

import com.example.empresapractica.Model.Areas;
import com.example.empresapractica.Service.ServiceAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/areas/")
public class AreasController {

    @Autowired
    ServiceAreas service;


    @PostMapping("save")
    public Areas saveAreas(@RequestBody Areas areas, @RequestParam("idUser") Integer idUser){
        return service.saveArea(areas, idUser);
    }

    @GetMapping("/findAmountOfEmployees")
    public Integer cantidadAreas(){
        return service.cantidadAreas();
    }

    @GetMapping("/findAmountOfActiveEmployees")
    public Integer areasActivas(){
        return service.areasActivas();
    }

    @GetMapping("/findAmountOfInactiveEmployees")
    public Integer areasInactivas(){
        return service.areasInactivas();
    }

    @GetMapping("/findAmountOfAreasByName/{nameArea}")
    public Integer cantidadAreasNombre(@PathVariable String nameArea){
        return service.cantidadAreasNombre(nameArea);
    }
}

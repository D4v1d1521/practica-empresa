package com.example.empresapractica.Controller;

import com.example.empresapractica.Model.Areas;
import com.example.empresapractica.Model.User;
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

        Areas areas1 = service.saveArea(areas, idUser);

        return areas1;

    }

    @GetMapping("cantidad-areas")
    public Integer cantidadAreas(){

        Integer areas2 = service.cantidadAreas();

        return areas2;
    }

    @GetMapping("areas-activas")
    public Integer areasActivas(){

        Integer areas3 = service.areasActivas();
        return areas3;
    }

    @GetMapping("areas-inactivas")
    public Integer areasInactivas(){

        Integer areas4 = service.areasInactivas();
        return areas4;
    }

    @GetMapping("areas-por-nombre/{nameArea}")
    public Integer cantidadAreasNombre(@PathVariable String nameArea){

        Integer areas5 = service.cantidadAreasNombre(nameArea);

        return areas5;
    }

    @PutMapping("update/{idArea}")
    public void updateArea(@PathVariable Integer idArea,
                           @RequestBody Areas areasAct){
        Areas areas = service.findByIdArea(idArea);

        if(areas == null){
            System.out.println("No se encontro el area");
        }else {
            areas.setCodeArea(areasAct.getCodeArea());
            areas.setNameArea(areasAct.getNameArea());
            areas.setLeaderArea(areasAct.getLeaderArea());
            areas.setState(areasAct.getState());
            service.updateArea(areas);

        }
    }

    @GetMapping("getAll")
    public Iterable<Areas> getAll(){

        Iterable<Areas> areas8 = service.getAll();
        return areas8;
    }
}

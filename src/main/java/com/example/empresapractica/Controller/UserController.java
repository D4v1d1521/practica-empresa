package com.example.empresapractica.Controller;

import com.example.empresapractica.Model.User;
import com.example.empresapractica.Service.ServiceUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/user/")
@Validated
public class UserController {

    @Autowired
    ServiceUser service;

    @PostMapping("save")
    public User saveUsers(@Valid @RequestBody User user){
        return service.SaveUser(user);
    }

    @GetMapping("total-empleados")
    public Integer buscarCantidadEmpleados(){
        return service.buscarCantidadEmpleados();
    }

    @GetMapping("empleados-activos")
    public Integer empleadosActivos(){
        return service.empleadosActivos();
    }

    @GetMapping("empleados-inactivos")
    public Integer empleadosInactivos(){
        return service.empleadosInactivos();
    }

    @GetMapping("empleados-fechas")
    public Integer cantidadEmpleadosPorFecha(@RequestParam("date") String date) throws ParseException {
        return service.cantidadEmpleadosPorFecha(date);
    }

    @GetMapping("empleados-por-nombres/{name}")
    public Integer cantidadEmpleadosProNombre(@PathVariable String name){
        return service.cantidadEmpleadosProNombre(name);
    }

    @GetMapping("estado-area-usuario/{state}")
    public Integer cantidadUsersAndAreaByState(@PathVariable Integer state){
        return service.cantidadUsersAndAreaByState(state);
    }

    @GetMapping("empleado-por-salario/{salary}")
    public Integer cantidadUserBySalary(@PathVariable Double salary){
        return service.cantidadUserBySalary(salary);
    }

    @GetMapping("usuario-por-edad/{age}")
    public Integer cantidadUsuariosPorEdad(@PathVariable Integer age){
        return service.cantidadUsuariosPorEdad(age);
    }

    @GetMapping("usuario-por-numeroDocumento/{numberDocument}")
    public Integer cantidadUserPorNumeroDeDocumento(@PathVariable Integer numberDocument){
        return service.cantidadUserPorNumeroDeDocumento(numberDocument);
    }

}

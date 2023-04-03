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

        User user1 = service.SaveUser(user);

        return user1;
    }

    @GetMapping("total-empleados")
    public Integer buscarCantidadEmpleados(){

        Integer user2 = service.buscarCantidadEmpleados();

        return user2;
    }

    @GetMapping("empleados-activos")
    public Integer empleadosActivos(){

        Integer user3 = service.empleadosActivos();

        return user3;
    }

    @GetMapping("empleados-inactivos")
    public Integer empleadosInactivos(){

        Integer user4 = service.empleadosInactivos();

        return user4;
    }

    @GetMapping("empleados-fechas")
    public Integer cantidadEmpleadosPorFecha(@RequestParam("date") String date) throws ParseException {

        Integer user5 = service.cantidadEmpleadosPorFecha(date);

        return user5;
    }

    @GetMapping("empleados-por-nombres/{name}")
    public Integer cantidadEmpleadosProNombre(@PathVariable String name){
        Integer user6 = service.cantidadEmpleadosProNombre(name);
        return user6;
    }

    @GetMapping("estado-area-usuario/{state}")
    public Integer cantidadUsersAndAreaByState(@PathVariable Integer state){
        Integer user7 = service.cantidadUsersAndAreaByState(state);
        return user7;
    }

    @GetMapping("empleado-por-salario/{salary}")
    public Integer cantidadUserBySalary(@PathVariable Double salary){

        Integer user8 = service.cantidadUserBySalary(salary);
        return user8;
    }

    @GetMapping("usuario-por-edad/{age}")
    public Integer cantidadUsuariosPorEdad(@PathVariable Integer age){

        Integer user9 = service.cantidadUsuariosPorEdad(age);
        return user9;
    }

    @GetMapping("usuario-por-numeroDocumento/{numberDocument}")
    public Integer cantidadUserPorNumeroDeDocumento(@PathVariable Integer numberDocument){

        Integer user10 = service.cantidadUserPorNumeroDeDocumento(numberDocument);
        return user10;
    }

    @PutMapping("update/{idUser}")
    public void updateUser(@PathVariable Integer idUser,
                           @RequestBody User userAct){
        User user = service.findById(idUser);
        if (user == null){
            System.out.println("No se encontro el usuario");
        }else {
            user.setName(userAct.getName());
            user.setLastName(userAct.getLastName());
            user.setBirthDate(userAct.getBirthDate());
            user.setEmail(userAct.getEmail());
            user.setDocumentNumber(userAct.getDocumentNumber());
            user.setSalary(userAct.getSalary());
            user.setPosition(userAct.getPosition());
            user.setState(userAct.getState());
            service.updateUser(user);


        }
    }

    @GetMapping("getAll")
    public Iterable<User> getAll(){
        Iterable<User> user12 = service.getAll();
        return user12;
    }

}

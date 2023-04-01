package com.example.empresapractica.Service;

import com.example.empresapractica.Model.User;
import com.example.empresapractica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class ServiceUser {

    @Autowired
    UserRepository repository;


    public User SaveUser(User user){
        return repository.save(user);
    }

    public Integer buscarCantidadEmpleados(){
        return repository.buscarCantidadEmpleados();
    }

    public Integer empleadosActivos(){
        return repository.empleadosActivos();
    }

    public Integer empleadosInactivos(){
        return repository.empleadosInactivos();
    }

    public Integer cantidadEmpleadosPorFecha(String date) throws ParseException {
        String date1 = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        return repository.cantidadEmpleadosPorFecha(date1);
    }

    public Integer cantidadEmpleadosProNombre(String name){
        return repository.cantidadEmpleadosProNombre(name);
    }

    public Integer cantidadUsersAndAreaByState(Integer state){
        return repository.cantidadUsersAndAreaByState(state);
    }

    public Integer cantidadUserBySalary(Double salary){
        return repository.cantidadUserBySalary(salary);
    }

    public Integer cantidadUsuariosPorEdad(Integer age){
        return repository.cantidadUsuariosPorEdad(age);
    }

    public Integer cantidadUserPorNumeroDeDocumento(Integer numberDocument){
        return repository.cantidadUserPorNumeroDeDocumento(numberDocument);
    }
}

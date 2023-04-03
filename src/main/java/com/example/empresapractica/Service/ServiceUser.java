package com.example.empresapractica.Service;

import com.example.empresapractica.Model.User;
import com.example.empresapractica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    UserRepository repository;


    public User SaveUser(User user){

        User user1 = repository.save(user);

        return user1;
    }

    public Integer buscarCantidadEmpleados(){

        Integer user2 = repository.buscarCantidadEmpleados();

        return user2;
    }

    public Integer empleadosActivos(){
        Integer user3 = repository.empleadosActivos();

        return user3;
    }

    public Integer empleadosInactivos(){

        Integer user4 = repository.empleadosInactivos();

        return user4;
    }

    public Integer cantidadEmpleadosPorFecha(String date) throws ParseException {
        String date1 = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(date));

        Integer user5 = repository.cantidadEmpleadosPorFecha(date1);

        return user5;
    }

    public Integer cantidadEmpleadosProNombre(String name){

        Integer user6 = repository.cantidadEmpleadosProNombre(name);
        return user6;
    }

    public Integer cantidadUsersAndAreaByState(Integer state){

        Integer user7 = repository.cantidadUsersAndAreaByState(state);

        return user7;
    }

    public Integer cantidadUserBySalary(Double salary){

        Integer user8 = repository.cantidadUserBySalary(salary);

        return user8;
    }

    public Integer cantidadUsuariosPorEdad(Integer age){

        Integer user9 = repository.cantidadUsuariosPorEdad(age);

        return user9;
    }

    public Integer cantidadUserPorNumeroDeDocumento(Integer numberDocument){

        Integer user10 = repository.cantidadUserPorNumeroDeDocumento(numberDocument);

        return user10;
    }

    public User updateUser(User user){

        User user11 = repository.save(user);
        return user11;
    }

    public  User findById(Integer idUser){
        User user12 = repository.findByIdUser(idUser);

        return  user12;
    }

    public Iterable<User> getAll(){

        Iterable<User> user13 = repository.findAll();
        return user13;
    }
}

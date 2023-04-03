package com.example.empresapractica.Service;

import com.example.empresapractica.Enums.Role;
import com.example.empresapractica.Model.Areas;
import com.example.empresapractica.Model.User;
import com.example.empresapractica.Repository.AreaRepository;
import com.example.empresapractica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAreas {

    @Autowired
    AreaRepository repository;

    @Autowired
    UserRepository userRepository;


    public Areas saveArea(Areas area, Integer idUser){
        try {
            User user = userRepository.findByIdUserAndRoles(idUser, Role.LEADER);



            if (area.getLeaderArea().getIdUser().equals(user.getIdUser()) && user != null) {

                Areas area1 = repository.save(area);
                return area1 ;
            }else{
                throw new Exception("El usuario no tiene el rol requerido");
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Integer cantidadAreas(){

        Integer areas2 = repository.cantidadAreas();

        return areas2;
    }

    public Integer areasActivas(){

        Integer areas3 = repository.areasActivas();

        return areas3;
    }

    public Integer areasInactivas(){

        Integer areas4 = repository.areasInactivas();
        return areas4;
    }

    public Integer cantidadAreasNombre(String nameArea){

        Integer areas5 = repository.cantidadAreasNombre(nameArea);

        return areas5;
    }

     public Areas findByIdArea(Integer idArea){

        Areas areas6 = repository.findByIdArea(idArea);

        return areas6;
     }

     public Areas updateArea(Areas areas){

        Areas areas7 = repository.save(areas);

        return areas7;
     }

    public Iterable<Areas> getAll(){

        Iterable<Areas> areas8 = repository.findAll();

        return areas8;
    }
}


package com.example.empresapractica.Service;

import com.example.empresapractica.Enums.Role;
import com.example.empresapractica.Model.Areas;
import com.example.empresapractica.Model.User;
import com.example.empresapractica.Repository.AreaRepository;
import com.example.empresapractica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

                return repository.save(area);
            }else{
                throw new Exception("El usuario no tiene el rol requerido");
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Integer cantidadAreas(){
        return repository.cantidadAreas();
    }

    public Integer areasActivas(){
        return repository.areasActivas();
    }

    public Integer areasInactivas(){
        return repository.areasInactivas();
    }

    public Integer cantidadAreasNombre(String nameArea){
        return repository.cantidadAreasNombre(nameArea);
    }
}


package com.example.empresapractica.Repository;

import com.example.empresapractica.Enums.Role;
import com.example.empresapractica.Model.Areas;
import com.example.empresapractica.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Areas, Integer> {

    @Query(value = "SELECT COUNT(*) FROM area;", nativeQuery = true)
    Integer cantidadAreas();

    @Query(value = "SELECT COUNT(*) FROM area where state = 0;", nativeQuery = true)
    Integer areasActivas();

    @Query(value = "SELECT COUNT(*) FROM area where state = 1;", nativeQuery = true)
    Integer areasInactivas();

    @Query(value = "SELECT COUNT(*) FROM area WHERE name_area = ?;", nativeQuery = true)
    Integer cantidadAreasNombre(@Param("name_area") String nameArea);

    Areas findByIdArea( Integer idArea);
}

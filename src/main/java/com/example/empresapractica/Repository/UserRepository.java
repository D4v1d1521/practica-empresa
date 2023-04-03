package com.example.empresapractica.Repository;

import com.example.empresapractica.Enums.Role;
import com.example.empresapractica.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByIdUserAndRoles(Integer idUser, Role role);

    @Query(value = "SELECT COUNT(*) FROM user;", nativeQuery = true)
    Integer buscarCantidadEmpleados();

    @Query(value = "SELECT COUNT(*) FROM user where state = 0;", nativeQuery = true)
    Integer empleadosActivos();

    @Query(value = "SELECT COUNT(*) FROM user where state = 1;", nativeQuery = true)
    Integer empleadosInactivos();

    @Query(value = "SELECT COUNT(*) FROM user WHERE birth_date = ? ;",
            nativeQuery = true)
    Integer cantidadEmpleadosPorFecha(@Param("birth_date") String date);

    @Query(value = "SELECT COUNT(*) FROM user WHERE name = ?;",
            nativeQuery = true)
    Integer cantidadEmpleadosProNombre(@Param("name") String name);

    @Query(value = "SELECT (SELECT COUNT(*) FROM user WHERE state = ?1) +\n" +
            "(SELECT COUNT(*) FROM area WHERE state = ?1);",
            nativeQuery = true)
    Integer cantidadUsersAndAreaByState(@Param("state") Integer state);

    @Query(value = "SELECT COUNT(*) FROM user WHERE salary = ?;",
            nativeQuery = true)
    Integer cantidadUserBySalary(@Param("salary") Double salary);

    @Query(value = "SELECT COUNT(*) FROM user WHERE DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),birth_date)), '%Y') = ?;",
            nativeQuery = true)
    Integer cantidadUsuariosPorEdad(@Param("edad") Integer age);

    @Query(value = "SELECT COUNT(*) FROM user WHERE document_number = ?;",
            nativeQuery = true)
    Integer cantidadUserPorNumeroDeDocumento(@Param("document_number")
                                              Integer numberDocument);

    User findByIdUser(Integer idUser);

}

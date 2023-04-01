package com.example.empresapractica.Model;

import com.example.empresapractica.Enums.Deserializable.Deserialize;
import com.example.empresapractica.Enums.Role;
import com.example.empresapractica.Enums.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {



    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(length = 50)
    @NotEmpty
    private String name;

    @Column(length = 50)
    @NotEmpty
    private String lastName;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthDate;

    @Column(length = 50)
    @NotEmpty
    @Email(message = "El correo electronico debe ser valido")
    private String email;

    @Column(length = 10, unique = true)
    @NotNull
    private Integer documentNumber;

    @Column(length = 10)
    @NotNull
    private Double salary;

    @Column(length = 50)
    @NotEmpty
    private String position;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @JsonDeserialize(using = Deserialize.class)
    private State state;





}

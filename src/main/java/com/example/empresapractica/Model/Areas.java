package com.example.empresapractica.Model;

import com.example.empresapractica.Enums.Deserializable.Deserialize;
import com.example.empresapractica.Enums.State;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "area")
public class Areas implements Serializable {



    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area", nullable = false)
    private Integer idArea;

    @Column(length = 2, unique = true)
    private Integer codeArea;

    @Column(length = 50)
    private String nameArea;

    @JsonDeserialize(using = Deserialize.class)
    private State state;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User leaderArea;

}

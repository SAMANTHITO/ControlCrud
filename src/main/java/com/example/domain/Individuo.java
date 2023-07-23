package com.example.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "individuos")
public class Individuo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_individuo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String edad;

}

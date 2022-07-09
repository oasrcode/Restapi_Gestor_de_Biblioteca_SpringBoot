package com.oasr.biblioteca.Modelos;

import lombok.Data;

import javax.persistence.*;

@Entity

@Data
public class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic
    @Column(name = "N_Carnet")
    private long nCarnet;
    @Basic
    @Column(name = "Telefono")
    private String telefono;
    @Basic
    @Column(name = "Email")
    private String email;


}

package com.oasr.biblioteca.Modelos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Libros {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "Titulo")
    private String titulo;
    @Basic
    @Column(name = "Autor")
    private String autor;
    @Basic
    @Column(name = "Editorial")
    private String editorial;
    @Basic
    @Column(name = "Genero")
    private String genero;
    @Basic
    @Column(name = "ISBN")
    private long isbn;


}

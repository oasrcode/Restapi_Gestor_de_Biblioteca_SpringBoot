package com.oasr.biblioeca.Modelos;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ejemplares {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "Codigo")
    private String codigo;
    @Basic
    @Column(name = "Estado")
    private int estado;
    @ManyToOne
    @JoinColumn(name = "ID_Libro", referencedColumnName = "ID", nullable = false)
    private Libros libro;
}

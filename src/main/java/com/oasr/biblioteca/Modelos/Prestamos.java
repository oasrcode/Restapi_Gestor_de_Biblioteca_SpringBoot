package com.oasr.biblioteca.Modelos;



import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Prestamos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "Fecha_Prestamo")
    private Date fecha_prestamo;
    @Basic
    @Column(name = "Fecha_Entraga")
    private Date fecha_entrega;
    @ManyToOne
    @JoinColumn(name = "ID_Ejemplar", referencedColumnName = "ID", nullable = false)
    private Ejemplares ejemplar;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario", referencedColumnName = "ID", nullable = false)
    private Usuarios usuario;


}
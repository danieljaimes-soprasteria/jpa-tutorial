package com.JPAmanual.capitulo4.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DIRECTOR")
public class Director implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_DIRECTOR")
    private int id_director;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @OneToMany(mappedBy = "director", cascade = CascadeType.PERSIST)
    private List<Pelicula> peliculas = new ArrayList<>();

    public Director() {
    }

    public Director(int id, String nombre, String nacionalidad) {
        super();
        this.id_director = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public boolean equals(Object elOtro) {
        if (elOtro instanceof Director) {
            Director d = (Director) elOtro;
            return this.id_director == d.id_director;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id_director;
    }

    @Override
    public String toString() {
        return String.format("id=%d, nombre=%s, nacionalidad=%s", this.id_director,
                this.nombre, this.nacionalidad);
    }

    //Método para poder imprimir por pantalla solo el nombre del director
    public String toStringPelicula() {
        return String.format("%s", this.nombre);
    }

    public int getId_director() {
        return id_director;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
}
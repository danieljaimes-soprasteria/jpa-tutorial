package com.JPAmanual.capitulo4.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTORA")
public class Productora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_PRODUCTORA")
    private int id_productora;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PAIS")
    private String pais;
    @OneToMany(mappedBy = "productora", cascade = CascadeType.PERSIST)
    private List<Pelicula> peliculas = new ArrayList<>();

    public Productora() {
    }

    public Productora(int id, String nombre, String pais) {
        super();
        this.id_productora = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    @Override
    public boolean equals(Object laOtra) {
        if (laOtra instanceof Productora) {
            Productora p = (Productora) laOtra;
            return this.id_productora == p.id_productora;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id_productora;
    }

    @Override
    public String toString() {
        return String.format("id=%d, nombre=%s, pais=%s", this.id_productora, this.nombre,
                this.pais);
    }

    public String toStringPelicula() {
        return String.format("%s", this.nombre);
    }

    public int getId_productora() {
        return id_productora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
}

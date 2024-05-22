package com.JPAmanual.capitulo4.service;

import com.JPAmanual.capitulo4.entidad.Pelicula;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ServicioPelicula {
    public static List<Pelicula> getPeliculasAll(EntityManager em) {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = em.createNamedQuery("pelicula.all", Pelicula.class).getResultList();
        return peliculas;
    }

    public static Pelicula TPQuery(EntityManager em) {
        TypedQuery<Pelicula> p = em.createQuery(
                "SELECT p FROM Pelicula p WHERE p.id_pelicula = 4", Pelicula.class);
        try {
            return p.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static List<Pelicula> getPeliculasGenero(EntityManager em) {
        String a = "Ciencia Ficción";
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = em.createNamedQuery("pelicula.por.genero",
                Pelicula.class).setParameter("genero", a).getResultList();
        return peliculas;
    }

    public static List<Pelicula> getPeliculasDirector(EntityManager em) {
        String a = "Guy Ritchie";
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = em.createNamedQuery("pelicula.por.director",
                Pelicula.class).setParameter("director", a).getResultList();
        return peliculas;
    }

    public static List<Object[]> getPeliculasJoinDirectorWhere(EntityManager em) {
        List<Object[]> peliculas = new ArrayList<Object[]>();
        peliculas = em.createNamedQuery("pelicula.join.director.where",
                Object[].class).getResultList();
        return peliculas;
    }

    public static List<Object[]> getPeliculasGroupByHaving(EntityManager em) {
        List<Object[]> peliculas = new ArrayList<Object[]>();
        peliculas = em.createNamedQuery("pelicula.groupBy.having",
                Object[].class).getResultList();
        return peliculas;
    }

    public static void updatePelicula(EntityManager em) {
        em.createNamedQuery("pelicula.UPD").executeUpdate();
    }

    public static void deletePelicula(EntityManager em) {
        em.createNamedQuery("pelicula.DEL").executeUpdate();
    }
}

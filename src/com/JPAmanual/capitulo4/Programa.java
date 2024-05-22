package com.JPAmanual.capitulo4;

import com.JPAmanual.capitulo4.entidad.Pelicula;
import com.JPAmanual.capitulo4.service.ServicioPelicula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cine");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Pelicula> l = ServicioPelicula.getPeliculasAll(em);
        for (Pelicula p : l)
            System.out.println(p.toString());
        l.clear();

        l = ServicioPelicula.getPeliculasDirector(em);
        for (Pelicula p : l)
            System.out.println(p.toString());
        l.clear();

        List<Object[]> m = ServicioPelicula.getPeliculasJoinDirectorWhere(em);
        for(Object[] p: m){
            System.out.println(Arrays.toString(p));
        }


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
package com.JPAmanual.servicios;

import com.JPAmanual.entidad.Animal;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ServicioAnimal {
    // Persist
    public static Animal crearAnimal(EntityManager em, String id, String nombre,
                                     String clase, String hábitat) {
        Animal a = new Animal(id, nombre, clase, hábitat);
        em.persist(a);
        return a;
    }

    // Find
    public static Animal encontrarAnimal(EntityManager em, String id) {
        return em.find(Animal.class, id);
    }

    // Remove
    public static boolean borrarAnimal(EntityManager em, String id) {
        Animal a = em.find(Animal.class, id);
        if (a != null) {
            em.remove(a);
            return true;
        }
        return false;
    }

    // Update Animal
    public static Animal modificarAnimal(EntityManager em, String id, String nombre,
                                         String clase, String hábitat) {
        Animal a = em.find(Animal.class, id);
        if (a != null) {
            a.setNombre(nombre);
            a.setClase(clase);
            a.setHabitat(hábitat);
        }
        return a;
    }

    public static List<String> getNombres(EntityManager em) {
        List<String> Nombres = new ArrayList<String>();
        Nombres = em.createNamedQuery("Animal.nombre", String.class).getResultList();
        return Nombres;
    }
}
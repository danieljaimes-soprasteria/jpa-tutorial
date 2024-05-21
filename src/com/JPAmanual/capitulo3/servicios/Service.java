package com.JPAmanual.capitulo3.servicios;

import com.JPAmanual.capitulo3.entidad.*;

import javax.persistence.EntityManager;
import java.util.List;

public class Service {
    public static void insertarLocation(EntityManager em, Location location) {
        em.persist(location);
    }

    public static void insertarFlora(EntityManager em, Flora flora) {
        em.persist(flora);
    }

    public static Location buscarLocation(EntityManager em2, int id) {
        return em2.find(Location.class, id);
    }

    public static Flora buscarFlora(EntityManager em, int id) {
        return em.find(Flora.class, id);
    }

    public static Tree buscarTree(EntityManager em, int id) {
        return em.find(Tree.class, id);
    }

    public static Bush buscarBush(EntityManager em, int id) {
        return em.find(Bush.class, id);
    }

    public static List<Compatible> buscarCompatibles(EntityManager em) {
        List<Compatible> compatibleList = em.createQuery("Select c From Compatible c", Compatible.class).getResultList();
        return compatibleList;
    }
}

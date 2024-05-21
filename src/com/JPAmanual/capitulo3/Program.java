package com.JPAmanual.capitulo3;

import com.JPAmanual.capitulo3.entidad.*;
import com.JPAmanual.capitulo3.servicios.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        firstMain();
        secondMain();

    }

    private static void firstMain() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("plant");
        EntityManager em1 = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();
        em1.getTransaction().begin();
        Location l1 = new Location();
        l1.setName("Parque natural Sierra Calderona");
        l1.setGpsCoordinates("6515, 1398");
        Location l2 = new Location();
        l2.setName("Parque Natural Sierras de Cazorla");
        l2.setGpsCoordinates("1843, 4915");
        Location l3 = new Location();
        l3.setName("Parque Nacional de Los Picos de Europa");
        l3.setGpsCoordinates("7337, 9318");
        Service.insertarLocation(em1, l1);
        Service.insertarLocation(em1, l2);
        Service.insertarLocation(em1, l3);
        em1.getTransaction().commit();
        em1.close();
        em2.getTransaction().begin();
        List<Flora> flora = new ArrayList<Flora>() {{
            add(new Flora());
            add(new Flora());
            add(new Flora());
            add(new Flora());
            add(new Flora());
        }};
        Location l = Service.buscarLocation(em2, 1);
        flora.get(0).setType("TREE");
        flora.get(0).setTypeId(1);
        flora.get(0).setLocation(l);
        flora.get(1).setType("BUSH");
        flora.get(1).setTypeId(2);
        flora.get(1).setLocation(l);
        flora.get(2).setType("BUSH");
        flora.get(2).setTypeId(1);
        flora.get(2).setLocation(l);
        flora.get(3).setType("TREE");
        flora.get(3).setTypeId(4);
        flora.get(3).setLocation(l);
        flora.get(4).setType("TREE");
        flora.get(4).setTypeId(2);
        flora.get(4).setLocation(l);
        for (Flora f : flora) {
            Service.insertarFlora(em2, f);
        }
        em2.getTransaction().commit();
        em2.close();
        emf.close();
    }

    private static void secondMain() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("plant");
        EntityManager em = emf.createEntityManager();
        Location l = Service.buscarLocation(em, 1);
        // Hay que buscar por nombre las Plants de flora
        for (Flora f : l.getFlora()) {
            if (f.getPlant() instanceof Tree) {
                f.setPlant(Service.buscarTree(em, f.getPlant().getId()));
            } else if (f.getPlant() instanceof Bush) {
                f.setPlant(Service.buscarBush(em, f.getPlant().getId()));
            }
        }
        // comprobamos que las plantas ya han sido cargadas
        System.out.println(Service.buscarFlora(em, 1) + "\nLocation 1: " +
                l.getFlora());
        System.out.println("-----------------");
        // ----- separamos las especies para calculo final de la estabilidad
        List<Tree> trees = new ArrayList<Tree>();
        List<Bush> bushes = new ArrayList<Bush>();
        for (Flora f : l.getFlora()) {
            if (f.resolvePlantType().equals("Tree")) {
                trees.add((Tree) f.getPlant());
            } else if (f.resolvePlantType().equals("Bush")) {
                bushes.add((Bush) f.getPlant());
            }
        }
        System.out.println("La lista de arboles es: " + trees + "\nLa lista de arbustos es: " + bushes);
        System.out.println("-----------------");
        // calculamos la estabilidad
        List<Compatible> compatible = Service.buscarCompatibles(em);
        l.setFloraStability(0);
        int relaciones = 0;
        for (Compatible c : compatible) {
            for (Bush b : bushes) {
                for (Tree t : trees) {
                    if (c.getBushId() == b.getId() && c.getTreeId() ==
                            t.getId()) {
                        System.out.println("relación " + b.getName() +
                                " con " + t.getName() + ", riesgo: " +
                                c.getRisk());
                        relaciones++;
                        l.addRisk(c.getRisk());
                    }
                }
            }
        }
        l.averageStability(relaciones);
        System.out.println("La estabilidad de '" + l.getName() + "' es de " +
                l.getFloraStability());
        em.close();
        emf.close();
    }
}

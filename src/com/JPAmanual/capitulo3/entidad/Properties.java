package com.JPAmanual.capitulo3.entidad;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Properties {
    private Leaf leafType;
    private Habitat habitat;
    public Properties() {
    }
    @Override
    public String toString() {
        return "Leaf: " + leafType + ", Habitat: " + habitat ;
    }
}
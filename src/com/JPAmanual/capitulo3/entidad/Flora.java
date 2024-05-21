package com.JPAmanual.capitulo3.entidad;

import javax.persistence.*;

@Entity
@Table(name = "FLORA")
@Access(AccessType.FIELD)
public class Flora {
    @Id
    @Column(name = "FLORA_ID")
    @SequenceGenerator(name = "Gen2", sequenceName = "Seq2")
    @GeneratedValue(generator = "Gen2")
    private int id;
    @ManyToOne
    @JoinColumn(name = "LOCATED_ID")
    private Location location;
    @Transient
    private Plant plant;

    public Flora() {
    }

    public void setLocation(Location l) {
        this.location = l;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "FLORA_TYPE")
    public String getType() {
        return plant.getClass().getSimpleName();
    }

    public void setType(String type) {
        if (this.plant == null) {
            initPlant(type);
        } else {
            modifyPlant(type);
        }
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "FLORA_TYPE_ID")
    public int getTypeId() {
        if (plant instanceof Tree) {
            return plant.getId();
        }
        if (plant instanceof Bush) {
            return plant.getId();
        } else
            return 0;
    }

    public void setTypeId(int id) {
        if (plant == null)
            this.plant = new Tree(id);
        else
            this.plant.setId(id);
    }

    private void initPlant(String type) {
        if (type.equals("TREE"))
            this.plant = new Tree();
        if (type.equals("BUSH"))
            this.plant = new Bush();
    }

    private void modifyPlant(String type) {
        if (type.equals("TREE")) {
            this.plant = new Tree(this.plant.getId());
        } else if (type.equals("BUSH")) {
            this.plant = new Bush(this.plant.getId());
        } else {
            System.err.println("Tipo " + type + " no reconocido");
        }
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String resolvePlantType() {
        return this.getType();
    }
}
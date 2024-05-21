package com.JPAmanual.capitulo3.entidad;

import javax.persistence.*;

@Entity
@Table(name = "BUSHES")
public class Bush extends Plant {
    @Id
    @Column(name = "BUSH_ID")
    private int id;
    @Column(name = "BUSH_NAME")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "leafType", column = @Column(name = "LEAF_ID")),
            @AttributeOverride(name = "habitat", column = @Column(name = "HABITAT_ID"))
    })
    private Properties properties;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "BUSH_DESCRIPTION")
    private String description;

    @Transient
    private double floraStability;

    public Bush(int id) {
        super();
        this.id = id;
    }

    public Bush() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    public double getFloraStability() {
        return this.floraStability;
    }
    public void setFloraStability(int i) {
        this.floraStability = i;
    }
    public void addRisk(int risk) {
        this.floraStability = this.floraStability + risk;
    }
    public void averageStability(int num) {
        this.floraStability = this.floraStability/num;
    }
}

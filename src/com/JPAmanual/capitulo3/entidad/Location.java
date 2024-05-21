package com.JPAmanual.capitulo3.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOCATED")
public class Location {
    @Transient
    private double floraStability;

    @Id
    @SequenceGenerator(name = "Gen", sequenceName = "Seq")
    @GeneratedValue(generator = "Gen")
    @Column(name = "LOCATED_ID")
    private int id;
    @Column(name = "LOCATED_NAME")
    private String name;
    @Column(name = "LOCATED_COORD")
    private String gpsCoordinates;
    @OneToMany(mappedBy = "location")
    private List<Flora> flora;

    public void setName(String name) {
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public List<Flora> getFlora() {
        return this.flora;
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

    public String getName() {
        return name;
    }
}

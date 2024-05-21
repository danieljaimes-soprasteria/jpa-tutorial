package com.JPAmanual.capitulo3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COMPATIBLES")
public class Compatible implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COMPATIBLE_ID")
    private int id;
    @Column(name = "TREE_ID")
    private int treeId;
    @Column(name = "BUSH_ID")
    private int bushId;
    @Column(name = "COMPATIBLE_RISK")
    private int risk;
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Compatible ?
                ((Compatible) obj).getId() == this.treeId : false;
    }

    private int getId() {
        return id;
    }

    public int getBushId() {
        return bushId;
    }

    public int getTreeId() {
        return treeId;
    }

    public int getRisk() {
        return risk;
    }
}

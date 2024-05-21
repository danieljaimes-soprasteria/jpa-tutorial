package com.JPAmanual.capitulo3.entidad;

import javax.persistence.*;

@Entity
@Table(name = "TREES")
public class Tree extends Plant {
    @Id
    @Column(name = "TREE_ID")
    private int id;
    @Column(name = "TREE_NAME")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "leafType", column = @Column(name = "LEAF_TYPE")),
            @AttributeOverride(name = "habitat", column = @Column(name = "HABITAT"))
    })
    private Properties properties;

    public Tree(int id) {
        super();
        this.id = id;
    }

    public Tree() {

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
}

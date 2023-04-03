package com.productstorage.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "_category")
public class Category extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

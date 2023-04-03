package com.productstorage.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "_product")
public class Product extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String name;
    private BigDecimal piece;
    private Long limitPiece;
    @ManyToOne
    private Category category;

    @ManyToOne
    private Storage storage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPiece() {
        return piece;
    }

    public void setPiece(BigDecimal piece) {
        this.piece = piece;
    }

    public Long getLimitPiece() {
        return limitPiece;
    }

    public void setLimitPiece(Long limitPiece) {
        this.limitPiece = limitPiece;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}

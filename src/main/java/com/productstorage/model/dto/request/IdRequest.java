package com.productstorage.model.dto.request;

import javax.validation.constraints.NotNull;

public class IdRequest {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

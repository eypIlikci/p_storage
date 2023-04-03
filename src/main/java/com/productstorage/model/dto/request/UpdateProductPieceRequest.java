package com.productstorage.model.dto.request;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UpdateProductPieceRequest {
    @NotNull
    private Long productId;

    @NotNull
    private BigDecimal value;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

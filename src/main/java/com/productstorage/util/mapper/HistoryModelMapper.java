package com.productstorage.util.mapper;

import com.productstorage.model.dto.response.HistoryResponse;
import com.productstorage.model.entity.History;
import org.springframework.stereotype.Component;

@Component
public class HistoryModelMapper {

    public HistoryResponse map(History history){
        HistoryResponse response=new HistoryResponse();
        response.setProductId(history.getProductId());
        response.setDate(history.getDate());
        response.setType(history.getType());
        return response;
    }
}

package com.productstorage.service;

import com.productstorage.model.dto.request.IdRequest;

public interface MailService {
    public void sendLimitPieceMail(IdRequest request);
}

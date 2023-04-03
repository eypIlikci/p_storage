package com.productstorage.config.listiner;

import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.service.MailService;
import com.productstorage.util.event.LimitPieceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LimitPieceEventListener{
    private final MailService mailService;

    @Autowired
    public LimitPieceEventListener(MailService mailService) {
        this.mailService = mailService;
    }

    @Async
    @EventListener
    public void onApplicationEvent(LimitPieceEvent event) {
        IdRequest request = new IdRequest();
        request.setId(event.getProductId());
        mailService.sendLimitPieceMail(request);
    }
}
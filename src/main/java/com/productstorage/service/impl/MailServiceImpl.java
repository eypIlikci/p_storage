package com.productstorage.service.impl;

import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.service.MailService;
import com.productstorage.util.properties.EmailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final EmailProperties fromEmailProperties;
    private final String LIMIT_PIECE_SUB="SUB";

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender, EmailProperties fromEmailProperties) {
        this.mailSender = mailSender;
        this.fromEmailProperties = fromEmailProperties;
    }

    @Override
    public void sendLimitPieceMail(IdRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmailProperties.getFromEmail());
        message.setTo(fromEmailProperties.getToEmail());
        message.setSubject(LIMIT_PIECE_SUB);
        message.setText(request.getId()+" id li ürün limit eşiği aşıldı!!");
        mailSender.send(message);
    }
}

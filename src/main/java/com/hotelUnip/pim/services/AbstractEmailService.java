package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Gerente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;


    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(cliente,newPass);
        sendEmail(sm);
    }

    @Override
    public void sendFileEmail(Gerente gerente, String file) {
        SimpleMailMessage sm = prepareFileEmail(gerente,file);
        sendEmail(sm);
    }

    protected  SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha:" + newPass);
        return sm;
    }

    protected  SimpleMailMessage prepareFileEmail(Gerente gerente, String file){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(gerente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Relatório");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Arquivo:" + file);
        return sm;
    }

}

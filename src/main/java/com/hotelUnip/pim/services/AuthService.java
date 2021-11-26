package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.repositories.ClienteRepository;
import com.hotelUnip.pim.repositories.GerenteRepository;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    @Autowired
    private BCryptPasswordEncoder pe;

    public void sendNewPassword(String email){
        Cliente cliente = clienteRepository.findByEmail(email);
        if(cliente == null){
            throw new ObjectNotFoundException("Email não encontrado");
        }
        String newPass = newPassword();
        cliente.setSenha(pe.encode(newPass));

        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente,newPass);

    }

    public void sendFileEmail(String email){
        Gerente gerente = gerenteRepository.findByEmail(email);
        if(gerente == null){
            throw new ObjectNotFoundException("Email não encontrado");
        }
        emailService.sendFileEmail(gerente,email);

    }

    private String newPassword() {
        char[] vet = new char[10];
        for(int i= 0 ; i<10 ; i++){
        vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = random.nextInt(3);
        if(opt == 0){
            return (char) (random.nextInt(10) + 48 );
        }
        else if(opt == 1){
            return (char) (random.nextInt(26)+ 65);
        }
        else {
            return (char) (random.nextInt(26) + 97);
        }
    }


}

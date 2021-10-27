package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.repositories.PessoaRepository;
import com.hotelUnip.pim.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        if (pessoa == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(pessoa.getId(), pessoa.getEmail(), pessoa.getSenha(), pessoa.getPerfis());
    }

}

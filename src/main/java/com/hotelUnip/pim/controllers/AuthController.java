package com.hotelUnip.pim.controllers;

import com.hotelUnip.pim.dto.EmailDTO;
import com.hotelUnip.pim.security.JWTUtil;
import com.hotelUnip.pim.security.UserSS;
import com.hotelUnip.pim.services.AuthService;
import com.hotelUnip.pim.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping( value = "/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/refresh_token",method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization","Bearer" + token);
        response.addHeader("access-control-expose-headers","Authorization");
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@RequestBody @Valid EmailDTO obj){
        authService.sendNewPassword(obj.getEmail());
        return ResponseEntity.noContent().build();

    }


}

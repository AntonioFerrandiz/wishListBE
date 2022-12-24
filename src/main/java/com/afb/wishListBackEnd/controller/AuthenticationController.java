package com.afb.wishListBackEnd.controller;

import com.afb.wishListBackEnd.config.security.JwtUtils;
import com.afb.wishListBackEnd.domain.dto.Token.GetTokenResource;
import com.afb.wishListBackEnd.domain.model.Login;
import com.afb.wishListBackEnd.service.UserDetailsServiceImpl;
import com.afb.wishListBackEnd.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody Login login) throws Exception{
        try{
            authenticate(login.getUsername(), login.getPassword());
        } catch (Exception e){
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(login.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new GetTokenResource(token));

    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        } catch (DisabledException exception){
            throw new Exception("Usuario deshabilitado " + exception.getMessage());
        } catch (BadCredentialsException e){
        }
    }
}

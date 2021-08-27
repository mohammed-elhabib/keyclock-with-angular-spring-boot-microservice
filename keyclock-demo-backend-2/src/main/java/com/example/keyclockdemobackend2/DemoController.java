package com.example.keyclockdemobackend2;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping(value = "/api")

@CrossOrigin("*")
public class DemoController {

    @GetMapping(value = "/demo")
    public SenderResponse adminEndPoint( HttpServletRequest request) {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        var username = accessToken.getPreferredUsername();
        return new SenderResponse("hi "+username+" Admin microservices 2");
    }
    @GetMapping(value = "/manager")
    public SenderResponse managerEndPoint( HttpServletRequest request) {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        var username = accessToken.getPreferredUsername();



        return new SenderResponse("hi "+username+" Manger from microservice 2");
    }
}
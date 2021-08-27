package com.example.keyclcokdemobackcend.controllers;

import com.example.keyclcokdemobackcend.SenderResponse;
import com.example.keyclcokdemobackcend.SenderResponse2;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    KeycloakRestTemplate keycloakRestTemplate;
    @GetMapping(value = "/demo")
    public SenderResponse adminEndPoint(HttpServletRequest request) {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        Map<String, String> info = new HashMap<>();
        var username = accessToken.getPreferredUsername();
        try {
            var entity = keycloakRestTemplate.getForEntity("http://localhost:8889/api/demo", SenderResponse2.class);
            info.put("message2", entity.getBody().getMessage());
        } catch (Exception e) {
            info.put("message2", "hi "+username+" Unfortunately, you do not have the authority to admin microservice 2");

        }
        info.put("message", "Hello " + username + " From Admin microservice 1");
        return new SenderResponse(info);
    }

    @GetMapping(value = "/manager")
    public SenderResponse managerEndPoint(HttpServletRequest request) {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        Map<String, String> info = new HashMap<>();
        var username = accessToken.getPreferredUsername();
       /* info.put("username", username);
        var emailID = accessToken.getEmail();
        info.put("emailID", emailID);
        var lastname = accessToken.getFamilyName();
        info.put("lastname", lastname);
        var firstname = accessToken.getGivenName();
        info.put("firstname", firstname);

        var varrealmName = accessToken.getIssuer();
        info.put("varrealmName", varrealmName);
        accessToken.getScope();
        accessToken.getRealmAccess().getRoles();*/
        try {

            var entity = keycloakRestTemplate.getForEntity("http://localhost:8889/api/manager", SenderResponse2.class);
            info.put("message2", entity.getBody().getMessage());
        } catch (Exception e) {
            info.put("message2", "hi "+username+" Unfortunately, you do not have the authority to manger microservice 2");

        }
        info.put("message", "Hello " + username + " From Manger from microservice 1");

        return new SenderResponse(info);
    }
}
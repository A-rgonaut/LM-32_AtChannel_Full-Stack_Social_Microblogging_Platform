package com.unipa.atchannel.controller;

import com.unipa.atchannel.service.CredentialService;
import com.unipa.atchannel.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sign")
public class SignController {

    @Autowired
    private UserService userService;

    @Autowired
    private CredentialService credentialService;

    @PostMapping("/register")
    public String addUser(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String username, @RequestParam String email, @RequestParam String password) {

        credentialService.addCredential(username, password);
        userService.addUser(firstname, lastname, username, email);

        return "index";
    }
}

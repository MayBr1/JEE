package com.example.jeeproj.repository;

import com.example.jeeproj.repository.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class controleur {

    @Autowired
    private service loginService;

    // Page de login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Renvoie le template login.html
    }
    // Traitement de la connexion
    @PostMapping("/login")
    public String login(@RequestParam String cin, @RequestParam String tel, Model model) {
        login user = loginService.authenticateUser(cin, tel);
        if (user != null) {
            model.addAttribute("message", "Connexion réussie ! Bienvenue " + user.getNom());
            return "home";  // Ou la page de redirection après une connexion réussie
        }
        model.addAttribute("message", "Échec de la connexion. Vérifiez vos informations.");
        return "login";  // Retourne à la page login.html en cas d'échec
    }
    @PostMapping("/register")
    public String register(@RequestBody login user) {
        loginService.registerUser(user);
        return "Utilisateur enregistré avec succès !";
    }
}



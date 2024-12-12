package com.example.jeeproj.repository;




import com.example.jeeproj.repository.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class controleur {

    @Autowired
    private service loginService;

    @PostMapping("/register")
    public String register(@RequestBody login user) {
        loginService.registerUser(user);
        return "Utilisateur enregistré avec succès !";
    }

    @PostMapping("/login")
    public String login(@RequestParam String cin, @RequestParam String tel) {
        login user = loginService.authenticateUser(cin, tel);
        if (user != null) {
            return "Connexion réussie ! Bienvenue " + user.getNom();
        }
        return "Échec de la connexion. Vérifiez vos informations.";
    }
}

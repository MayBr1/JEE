package com.example.jeeproj.repository;

import com.example.jeeproj.repository.login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRep extends JpaRepository<login, String> {
    // Méthode pour rechercher un utilisateur par CIN
    login findByCin(String cin);
}
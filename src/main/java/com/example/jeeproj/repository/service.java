package com.example.jeeproj.repository;

import com.example.jeeproj.repository.LoginRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {

    @Autowired
    private LoginRep loginRepository;

    public login registerUser(login user) {
        return loginRepository.save(user);
    }

    public login authenticateUser(String cin, String tel) {
        login user = loginRepository.findByCin(cin);
        if (user != null && user.getTel().equals(tel)) {
            return user;
        }
        return null;
    }
}

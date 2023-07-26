package com.example.walletapi.services.interfaces;

import com.example.walletapi.models.User;

import java.util.List;

public interface UserInterface {
    List<User> findAll();
}

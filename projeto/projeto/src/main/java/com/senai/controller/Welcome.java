package com.senai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Welcome{
    @RequestMapping
    public String welcome(){
        return "Bem-vindo ao sistema de cadastro de usuários!";
    }




}

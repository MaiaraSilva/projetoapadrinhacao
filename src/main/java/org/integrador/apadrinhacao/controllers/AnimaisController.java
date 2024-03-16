package org.integrador.apadrinhacao.controllers;

import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.repositories.AnimaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/animais")
public class AnimaisController {
    @Autowired
    private AnimaisRepository animaisRepository;

    @GetMapping
    public List<AnimaisModel> buscaAnimais() {
        List<AnimaisModel> animal = animaisRepository.findAll();
        return animal;
    }
}

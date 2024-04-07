package org.integrador.apadrinhacao.controllers.animalController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.services.animalService.BuscaAnimalService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animal")
public class BuscaAnimalController {
    private final BuscaAnimalService buscaAnimalService;

    @GetMapping
    public List<AnimalModel> buscaAnimal() {
        return buscaAnimalService.getAllAnimal();
    }
}

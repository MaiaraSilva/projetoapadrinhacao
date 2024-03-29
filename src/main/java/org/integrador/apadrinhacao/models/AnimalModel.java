package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animais_tb")
public class AnimalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private String historia;
    private String personalidade_comportamento;
    private String compatibilidade;
    private String requisitos_apadrinhamento;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<FotoModel> fotos;

    @ManyToMany
    @JoinTable(
            name = "apadrinhamento_tb",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "padrinho_id")
    )
    private List<PadrinhoModel> padrinho;
}

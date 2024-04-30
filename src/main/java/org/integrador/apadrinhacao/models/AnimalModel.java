package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    private Date data_nascimento;
    private String descricao;
    private String cor;
    private String historia;
    private String raca;

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

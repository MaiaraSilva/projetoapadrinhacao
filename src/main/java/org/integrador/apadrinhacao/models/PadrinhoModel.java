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
@Table(name = "padrinho_tb")
public class PadrinhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String cidade;
    private String interesses;

    @ManyToMany
    @JoinTable(
            name = "apadrinhamentos_tb",
            joinColumns = @JoinColumn(name = "id_padrinho"),
            inverseJoinColumns = @JoinColumn(name = "id_animal")
    )
    private List<AnimaisModel> apadrinhamentos;
}

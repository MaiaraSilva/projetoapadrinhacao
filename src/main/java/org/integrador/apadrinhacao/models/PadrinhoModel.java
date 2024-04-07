package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.integrador.apadrinhacao.enums.StatusApadrinhamentoEnum;

import java.time.LocalDate;
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
    private String endereco;
    private LocalDate data_apadrinhamento;
    private StatusApadrinhamentoEnum status;

    @ManyToMany(mappedBy = "padrinho")
    private List<AnimalModel> animal;

}

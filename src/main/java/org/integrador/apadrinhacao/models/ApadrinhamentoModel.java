package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.integrador.apadrinhacao.enums.StatusApadrinhamentoEnum;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apadrinhamento_tb")
public class ApadrinhamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "padrinho_id")
    private PadrinhoModel padrinho;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalModel animal;

    private LocalDate dataApadrinhamento;
    @Enumerated(EnumType.STRING)
    private StatusApadrinhamentoEnum status;
}

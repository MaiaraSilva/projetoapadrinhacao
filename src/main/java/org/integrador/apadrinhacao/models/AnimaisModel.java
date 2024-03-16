package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.integrador.apadrinhacao.enums.EspecieEnum;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animais_tb")
public class AnimaisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private EspecieEnum especie;
    private Integer idade;
    private String descricao;
    private String foto;

    @ManyToMany(mappedBy = "apadrinhamentos")
    private List<PadrinhoModel> padrinhos;
}

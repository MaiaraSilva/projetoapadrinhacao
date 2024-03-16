package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.integrador.apadrinhacao.enums.StatusEnum;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apadrinhamentos_tb")
public class ApadrinhamentosModel {
    private Integer id_padrinho;
    private Integer id_animal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data_inicio;
    private StatusEnum status;
}

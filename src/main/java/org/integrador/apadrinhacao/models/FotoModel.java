package org.integrador.apadrinhacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.integrador.apadrinhacao.enums.TipoFotoEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foto_tb")
public class FotoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String caminho;
    @Enumerated(EnumType.STRING)
    private TipoFotoEnum tipo_foto;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalModel animal;
}

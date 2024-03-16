package org.integrador.apadrinhacao.enums;

public enum GeneroEnum {
    MACHO("Macho"),
    FEMEA("Fêmea");

    private final String descricao;

    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

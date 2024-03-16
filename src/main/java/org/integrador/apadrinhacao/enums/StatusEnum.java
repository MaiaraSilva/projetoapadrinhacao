package org.integrador.apadrinhacao.enums;

public enum StatusEnum {
    ATIVO("Ativo"),
    ENCERRADO("Encerrado");

    private final String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

package org.integrador.apadrinhacao.enums;

public enum StatusApadrinhamentoEnum {
    ATIVO("Ativo"),
    INATIVO("Inativo");
    private final String descricao;

    StatusApadrinhamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

package org.integrador.apadrinhacao.enums;

public enum TipoFotoEnum {

    PRINCIPAL("Principal"),
    SECUNDARIA("Secundária");
    private final String descricao;

    TipoFotoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}

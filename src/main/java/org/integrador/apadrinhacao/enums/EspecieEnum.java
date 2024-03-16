package org.integrador.apadrinhacao.enums;

public enum EspecieEnum {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    PASSARO("Pássaro");

    private final String descricao;

    EspecieEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

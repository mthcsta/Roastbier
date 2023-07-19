package com.roastbier.roastbier.enums;

public enum UnidadeMedida {
    UNIDADE("UNI", "Unidade"), PECA("PEC", "Peça"), LITRO("LT", "Litro"), KILOGRAMA("KG", "Kilograma"), CAIXA("CX", "Caixa"), FRASCO("FR", "Frasco"), GARRAFA("GAR", "Garrafa");

    private final String abreviacao;
    private final String unidade;

    UnidadeMedida(String abreviacao, String unidade) {
        this.abreviacao = abreviacao;
        this.unidade = unidade;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public static UnidadeMedida getByAbreviacao(String abreviacao) {
        if (abreviacao == null) {
            return null;
        }
        for (UnidadeMedida unidadeMedida : UnidadeMedida.values()) {
            if (unidadeMedida.getAbreviacao().equals(abreviacao)) {
                return unidadeMedida;
            }
        }
        throw new IllegalArgumentException(String.format("%s não foi encontrado(a)! Identificador = %s", UnidadeMedida.class.getSimpleName(), abreviacao));
    }

}

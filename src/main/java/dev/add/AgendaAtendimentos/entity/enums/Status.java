package dev.add.AgendaAtendimentos.entity.enums;

public enum Status {
    FINALIZADO("Finalizado"),
    ABERTO("Aberto"),
    EM_ANDAMENTO("Em Andamento"),
    CANCELADO("Cancelado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

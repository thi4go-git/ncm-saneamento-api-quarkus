package net.ddns.cloudtecnologia.exception;

public class ErroConexaoCosmosException extends RuntimeException {
    public ErroConexaoCosmosException() {
        super("Exception: Erro ao Solicitar informacao ao CosmosBluesoft!");
    }
}

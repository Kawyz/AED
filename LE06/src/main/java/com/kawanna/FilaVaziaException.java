package com.kawanna;

public class FilaVaziaException extends RuntimeException {
    public FilaVaziaException() {
        super("A fila está vazia.");
    }
}
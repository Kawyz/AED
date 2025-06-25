package com.kawanna;

public class FilaLista<T> {
    private No<T> inicio;
    private No<T> fim;

    public FilaLista() {
        inicio = null;
        fim = null;
    }

    public class No<T> {
        T info;
        No<T> prox;
    
        public No(T info) {
            this.info = info;
            this.prox = null;
        }
    
        public T getInfo() {
            return info;
        }
    
        public No<T> getProx() {
            return prox;
        }
    
        public void setProx(No<T> prox) {
            this.prox = prox;
        }
    }
    
    public boolean estaVazia() {
        return inicio == null;
    }

    public void inserir(T valor) {
        No<T> novo = new No<>(valor);

        if (estaVazia()) {
            inicio = novo;
        } else {
            fim.setProx(novo);
        }

        fim = novo;
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return inicio.getInfo();
    }

    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = inicio.getInfo();
        inicio = inicio.getProx();

        if (inicio == null) {
            fim = null; // A fila ficou vazia
        }

        return valor;
    }

    public void liberar() {
        inicio = null;
        fim = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = inicio;

        while (atual != null) {
            sb.append(atual.getInfo());

            if (atual.getProx() != null) {
                sb.append(",");
            }

            atual = atual.getProx();
        }

        return sb.toString();
    }
}

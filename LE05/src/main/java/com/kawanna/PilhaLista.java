package com.kawanna;

public class PilhaLista<T> {
    private ListaEncadeada<T> dados;

    public PilhaLista() {
        dados = new ListaEncadeada<>();
    }

    public void push(T valor) {
        dados.inserir(valor);
    }

    public T pop() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }

        T topo = dados.getPrimeiro().getInfo();
        dados.retirar(topo);
        return topo;
    }

    public T peek() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }

        return dados.getPrimeiro().getInfo();
    }

    public boolean estaVazia() {
        return dados.estaVazia();
    }

    public void liberar() {
        dados.liberar();
    }

    @Override
    public String toString() {
        return dados.toString();
    }
}

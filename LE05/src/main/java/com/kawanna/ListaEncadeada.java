package com.kawanna;

public class ListaEncadeada<T> {
    
    private NoLista<T> primeiro; 

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoLista<T> atual = buscar(valor);

        if (atual != null) {
            NoLista<T> anterior = atual.getAnterior();
            NoLista<T> proximo = atual.getProximo();

            if (anterior != null) {
                anterior.setProximo(proximo);
            } else {
                primeiro = proximo;
            }

            if (proximo != null) {
                proximo.setAnterior(anterior);
            }

            atual.setProximo(null);
            atual.setAnterior(null);
        } 
    }

    public void exibirOrdemInversa() {
        NoLista<T> atual = primeiro;

        if (atual == null) return;

        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        while (atual != null) {
            System.out.println(atual.getInfo() + " ");
            atual = atual.getAnterior();
        }

        System.out.println();
    }

    public void liberar() {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            NoLista<T> proximo = atual.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
            atual = proximo;
        }
        primeiro = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) sb.append(",");
            atual = atual.getProximo();
        }

        return sb.toString();
    }

    public boolean estaVazia() {
        return primeiro == null;
    }
}

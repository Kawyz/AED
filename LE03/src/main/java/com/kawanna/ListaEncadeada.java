package com.kawanna;

public class ListaEncadeada<T> {
    
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T value) { 
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(value);
        novo.setProximo(primeiro); //aponta o antigo primeiro
        primeiro = novo; //novo passa a ser o primeiro
    }

    public boolean estaVazia() { 
        return primeiro == null;
    }

    public NoLista<T> buscar(T value) { 
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(value)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T value) {
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiro;

        while (atual != null && !atual.getInfo().equals(value)) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (anterior == null) {
                primeiro = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> atual = primeiro;

        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public NoLista<T> obterNo(int position) {
        if (position < 0 || position >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Posição Inválida!");
        }

        NoLista<T> atual = primeiro;
        int contador = 0;

        while (contador < position) {
            atual = atual.getProximo();
            contador++;
        }

        return atual;
    }

   @Override
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
}

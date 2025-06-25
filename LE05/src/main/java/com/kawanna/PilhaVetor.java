package com.kawanna;

@SuppressWarnings("unchecked")

public class PilhaVetor<T> {

    private T[] info;
    private int topo;

    public PilhaVetor(int capacidade) {
        info = (T[]) new Object[capacidade];
        topo = 0; 
    }

    public void push(T valor) {
        if (topo == info.length) {
            throw new IllegalStateException("Pilha cheia");
        }
        info[topo] = valor;
        topo++;
    }

    public T pop() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        topo--;
        return info[topo];
    }

    public T peek() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return info[topo - 1];
    }

    public boolean estaVazia() {
        return topo == 0;
    }

    public void liberar() {
        for (int i = 0; i < topo; i++) {
            info[i] = null;
        }
        topo = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = topo - 1; i >= 0; i--) {
            sb.append(info[i]);
            if (i != 0) sb.append(",");
        }

        return sb.toString();
    }

    public PilhaVetor<T> concatenar(PilhaVetor<T> outra) {
        int novaCapacidade = this.topo + outra.topo;
        PilhaVetor<T> nova = new PilhaVetor<>(novaCapacidade);

        for (int i = 0; i < this.topo; i++) {
            nova.push(this.info[i]);
        }

        for (int i = 0; i < outra.topo; i++) {
            nova.push(outra.info[i]);
        }

        return nova;
    }
}


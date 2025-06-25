package com.kawanna;

@SuppressWarnings("unchecked")

public class FilaVetor<T> {
    private Object[] info;
    private int inicio;
    private int tamanho;

    public FilaVetor(int capacidade) {
        info = new Object[capacidade];
        inicio = 0;
        tamanho = 0;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            throw new FilaCheiaException();
        }

        int pos = (inicio + tamanho) % info.length;
        info[pos] = valor;
        tamanho++;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return (T) info[inicio];
    }

    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = (T) info[inicio];
        inicio = (inicio + 1) % info.length;
        tamanho--;
        return valor;
    }

    public void liberar() {
        inicio = 0;
        tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.tamanho + f2.tamanho);

        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.info.length;
            f3.inserir((T) this.info[pos]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            int pos = (f2.inicio + i) % f2.info.length;
            f3.inserir((T) f2.info[pos]);
        }

        return f3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % info.length;
            sb.append(info[pos]);

            if (i < tamanho - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    public int getLimite() {
        return info.length;
    }

    public void encolher() {
        if (tamanho == 0) {
            info = new Object[0];
            inicio = 0;
            return;
        }
    
        Object[] novoInfo = new Object[tamanho];
    
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % info.length;
            novoInfo[i] = info[indice];
        }
    
        info = novoInfo;
        inicio = 0;
    }
}

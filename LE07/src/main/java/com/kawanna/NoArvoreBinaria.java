package com.kawanna;

public class NoArvoreBinaria<T> {
    
    private T info;
    private NoArvoreBinaria<T> esquerdo;
    private NoArvoreBinaria<T> direito;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsq() {
        return esquerdo;
    }

    public void setEsquerdo(NoArvoreBinaria<T> esquerdo) {
        this.esquerdo = esquerdo;
    }

    public NoArvoreBinaria<T> getDir() {
        return direito;
    }

    public void setDireito(NoArvoreBinaria<T> direito) {
        this.direito = direito;
    }

    public String toString() {
        return info.toString();
    }
}
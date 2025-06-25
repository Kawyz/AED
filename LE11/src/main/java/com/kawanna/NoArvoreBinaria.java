package com.kawanna;

public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;

    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return toStringRec(this);
    }

    private String toStringRec(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo()
            + toStringRec(no.getEsquerda())
            + toStringRec(no.getDireita()) + ">";
    }
}

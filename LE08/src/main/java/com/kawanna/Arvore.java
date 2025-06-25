package com.kawanna;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public boolean pertence(T valor) {
        return pertence(raiz, valor);
    }

    private boolean pertence(NoArvore<T> no, T valor) {
        if (no == null) return false;

        if (no.getInfo().equals(valor)) return true;

        for (NoArvore<T> filho : no.getFilhos()) {
            if (pertence(filho, valor)) {
                return true;
            }
        }

        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) return 0;

        int total = 1; // Conta o próprio nó
        for (NoArvore<T> filho : no.getFilhos()) {
            total += contarNos(filho);
        }
        return total;
    }

    public String toString() {
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append("<").append(no.getInfo());

        for (NoArvore<T> filho : no.getFilhos()) {
            sb.append(obterRepresentacaoTextual(filho));
        }

        sb.append(">");
        return sb.toString();
    }
}

package com.kawanna;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T valor) {
        return pertence(raiz, valor);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T valor) {
        if (no == null) {
            return false;
        }
        if (no.getInfo().equals(valor)) {
            return true;
        }

        return pertence(no.getEsq(), valor) || pertence(no.getDir(), valor);
    }

    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }

        return "<" + no.getInfo() +
               arvorePre(no.getEsq()) +
               arvorePre(no.getDir()) + ">";
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }

        return 1 + contarNos(no.getEsq()) + contarNos(no.getDir());
    }

    public int contarFolhas(NoArvoreBinaria<T> sa) {
        if (sa == null) {
            return 0;
        }
        if (sa.getEsq() == null && sa.getDir() == null) {
            return 1;
        }
        return contarFolhas(sa.getEsq()) + contarFolhas(sa.getDir());
    }
}

package com.kawanna;

public abstract class ArvoreBinariaAbstract<T> {
    private NoArvoreBinaria<T> raiz;

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public boolean pertence(T valor) {
        return buscar(valor) != null;
    }

    public abstract NoArvoreBinaria<T> buscar(T valor);

    @Override
    public String toString() {
        return (raiz != null) ? raiz.toString() : "<>";
    }
}

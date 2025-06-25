package com.kawanna;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    @Override
    public NoArvoreBinaria<T> buscar(T valor) {
        return null; // apenas placeholder
    }
}


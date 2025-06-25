package com.kawanna;

public abstract class ListaAbstract<T> {
    private Object[] info;
    private int tamanho;

    public ListaAbstract() {
        info = new Object[10];
        tamanho = 0;
    }

    protected Object[] getInfo() {
        return info;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    protected int getTamanho() {
        return tamanho;
    }

    protected void redimensionar() {
        Object[] novo = new Object[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public abstract void inserir(T valor);
    public abstract int buscar(T valor); 
}

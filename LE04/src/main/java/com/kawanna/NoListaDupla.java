package com.kawanna;

public class NoListaDupla<T> {
    
    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }
    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}

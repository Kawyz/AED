package com.kawanna;

public class NoMapa<T> {
    private int chave;
    private T dado;

    public NoMapa(int chave, T dado) {
        this.chave = chave;
        this.dado = dado;
    }

    public int getChave() {
        return chave;
    }

    public T getDado() {
        return dado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NoMapa) {
            NoMapa<?> outro = (NoMapa<?>) obj;
            return this.chave == outro.chave;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" + chave + ": " + dado + "}";
    }
}

package com.kawanna;

import java.util.ArrayList;
import java.util.List;

public class NoArvore<T> {
    private T info;
    private List<NoArvore<T>> filhos;

    public NoArvore(T info) {
        this.info = info;
        this.filhos = new ArrayList<>();
    }

    public T getInfo() {
        return info;
    }

    public List<NoArvore<T>> getFilhos() {
        return filhos;
    }

    public void inserirFilho(NoArvore<T> filho) {
        filhos.add(filho);
    }

    public String toString() {
        return info.toString();
    }
}

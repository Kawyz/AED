package com.kawanna;

public abstract class OrdenacaoAbstract {
    protected int[] info;

    public OrdenacaoAbstract(int[] info) {
        this.info = info;
    }

    protected void trocar(int a, int b) {
        int temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }

    public int[] getInfo() {
        return info;
    }

    public abstract void ordenar();
}

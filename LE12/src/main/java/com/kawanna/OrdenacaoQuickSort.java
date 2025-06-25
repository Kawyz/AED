package com.kawanna;

public class OrdenacaoQuickSort extends OrdenacaoAbstract {

    public OrdenacaoQuickSort(int[] info) {
        super(info);
    }

    @Override
    public void ordenar() {
        quicksort(0, info.length - 1);
    }

    private void quicksort(int inicio, int fim) {
        if (inicio < fim) {
            int p = particionar(inicio, fim);
            quicksort(inicio, p - 1);
            quicksort(p + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int pivo = info[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (info[j] <= pivo) {
                i++;
                trocar(i, j);
            }
        }

        trocar(i + 1, fim);
        return i + 1;
    }
}

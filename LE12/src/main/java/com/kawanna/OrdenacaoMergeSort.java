package com.kawanna;

public class OrdenacaoMergeSort extends OrdenacaoAbstract {

    public OrdenacaoMergeSort(int[] info) {
        super(info);
    }

    @Override
    public void ordenar() {
        mergesort(0, info.length - 1);
    }

    private void mergesort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergesort(inicio, meio);
            mergesort(meio + 1, fim);
            intercalar(inicio, meio, fim);
        }
    }

    private void intercalar(int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (info[i] <= info[j]) {
                temp[k++] = info[i++];
            } else {
                temp[k++] = info[j++];
            }
        }

        while (i <= meio) {
            temp[k++] = info[i++];
        }

        while (j <= fim) {
            temp[k++] = info[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            info[inicio + x] = temp[x];
        }
    }
}

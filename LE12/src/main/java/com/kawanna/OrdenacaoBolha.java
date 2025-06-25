package com.kawanna;

public class OrdenacaoBolha extends OrdenacaoAbstract {

    public OrdenacaoBolha(int[] info) {
        super(info);
    }

    @Override
    public void ordenar() {
        for (int i = 0; i < info.length - 1; i++) {
            for (int j = 0; j < info.length - 1 - i; j++) {
                if (info[j] > info[j + 1]) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}

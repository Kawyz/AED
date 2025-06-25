package com.kawanna;

public class OrdenacaoBolhaOtimizada extends OrdenacaoAbstract {

    public OrdenacaoBolhaOtimizada(int[] info) {
        super(info);
    }

    @Override
    public void ordenar() {
        boolean trocou;
        for (int i = 0; i < info.length - 1; i++) {
            trocou = false;
            for (int j = 0; j < info.length - 1 - i; j++) {
                if (info[j] > info[j + 1]) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }
}

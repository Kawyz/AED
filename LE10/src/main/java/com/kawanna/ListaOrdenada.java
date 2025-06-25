package com.kawanna;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        Object[] dados = getInfo();
        int tamanho = getTamanho();

        if (tamanho == dados.length) {
            redimensionar();
            dados = getInfo(); 
        }

        int pos = 0;
        while (pos < tamanho && valor.compareTo((T) dados[pos]) > 0) {
            pos++;
        }

        for (int i = tamanho; i > pos; i--) {
            dados[i] = dados[i - 1];
        }

        dados[pos] = valor;
        setTamanho(tamanho + 1);
    }

    @Override
    public int buscar(T valor) {
        Object[] dados = getInfo();
        int inicio = 0;
        int fim = getTamanho() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo((T) dados[meio]);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        Object[] dados = getInfo();
        int tamanho = getTamanho();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[i]);
            if (i < tamanho - 1) sb.append(",");
        }

        return sb.toString();
    }
}

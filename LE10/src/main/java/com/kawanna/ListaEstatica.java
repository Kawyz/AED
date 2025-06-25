package com.kawanna;

public class ListaEstatica<T> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        Object[] dados = getInfo(); 
        int tamanho = getTamanho();

        if (tamanho == dados.length) {
            redimensionar();
            dados = getInfo(); 
        }

        dados[tamanho] = valor;
        setTamanho(tamanho + 1);
    }

    @Override
    public int buscar(T valor) {
        Object[] dados = getInfo();
        int tamanho = getTamanho();

        for (int i = 0; i < tamanho; i++) {
            if (dados[i].equals(valor)) {
                return i;
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

package com.kawanna;

import java.util.LinkedList;

public class MapaDispersao<T> {
    private LinkedList<NoMapa<T>>[] tabela;

    public MapaDispersao(int capacidade) {
        tabela = new LinkedList[capacidade];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int calcularHash(int chave) {
        return chave % tabela.length;
    }

    public void inserir(int chave, T dado) {
        int pos = calcularHash(chave);
        LinkedList<NoMapa<T>> lista = tabela[pos];

        NoMapa<T> novo = new NoMapa<>(chave, dado);

        if (!lista.contains(novo)) {
            lista.add(novo);
        } else {
            for (NoMapa<T> item : lista) {
                if (item.equals(novo)) {
                    lista.remove(item);
                    lista.add(novo);
                    break;
                }
            }
        }
    }

    public void remover(int chave) {
        int pos = calcularHash(chave);
        LinkedList<NoMapa<T>> lista = tabela[pos];

        lista.remove(new NoMapa<>(chave, null));
    }

    public T buscar(int chave) {
        int pos = calcularHash(chave);
        LinkedList<NoMapa<T>> lista = tabela[pos];

        for (NoMapa<T> item : lista) {
            if (item.getChave() == chave) {
                return item.getDado();
            }
        }

        return null;
    }
}

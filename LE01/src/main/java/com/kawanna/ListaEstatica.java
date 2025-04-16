package com.kawanna;

public class ListaEstatica {
    
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10]; //array cm 10 posições
        tamanho = 0; //faz a lista começar vazia
    }

    public void redimensionar() { //redimensiona quando fica cheio
        int[] novo = new int[info.length + 10]; //cria novo vetor c/10 posições
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i]; //copia os dados p novo
        }
        info = novo; //troca o antigo pelo novo
    }

    public void inserir(int value) { //adiciona um numero e redimensiona se precisar
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = value;
        tamanho++;
    }

    public void exibir() { //mostra os elementos, separa eles por espaços
        for (int i = 0; i < tamanho; i++) {
            System.out.print(info[i] + " "); //espaços
        }
        System.out.println();//pula linha
    }

    public int buscar(int value) { //procura o numero e retorna posição, se não achar retorna -1
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int value) { //remove o valor e reorganiza
        int position = buscar(value);
        if (position != -1) {
            for (int i = position; i < tamanho - 1; i++) {
                info[i] = info[i + 1]; //desloca tudo 1 posição à esquerda
            }
            tamanho--; //diminui tamanho
        }
    }

    public void liberar() { //limpa e volta ao tamanho original
        info = new int[10];
        tamanho = 0; 
    }

    public int obterElemento(int position) { //retorna o valor da posição informada
        if (position < 0 || position >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida!"); //exceção se for inválida
        }
        return info[position];
    }

    public boolean estaVazia() { //se não tem elementos retorna true
        return tamanho == 0;
    }

    public int getTamanho() { //retorna o num de elementos na lista
        return tamanho;
    }

    public String toString() {//retorna todos os valores da lista separando por ","
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) sb.append(",");
        }
        return sb.toString();
    }
}

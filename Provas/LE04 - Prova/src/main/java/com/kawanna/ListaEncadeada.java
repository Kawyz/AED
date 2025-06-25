package com.kawanna;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada<T> criarSubLista(int inicio, int fim) {
        if (inicio < 0 || fim < 0 || inicio > fim) {
            throw new IllegalArgumentException("Índices inválidos: início > fim ou negativos");
        }

        int tamanho = 0;
        NoLista<T> contador = primeiro;
        while (contador != null) {
            tamanho++;
            contador = contador.getProximo();
        }

        if (fim >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fim fora do limite da lista");
        }

        ListaEncadeada<T> subLista = new ListaEncadeada<>();

        NoLista<T> atual = primeiro;
        int pos = 0;

        while (pos < inicio) {
            atual = atual.getProximo();
            pos++;
        }

        while (pos <= fim) {
            subLista.inserirFim(atual.getInfo()); //mantem a ordem
            atual = atual.getProximo();
            pos++;
        }

        return subLista;
    }

    //Metdo adicionado para inserir os valores na ordem correta
    public void inserirFim(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
    
        if (primeiro == null) {
            primeiro = novo;
        } else {
            NoLista<T> atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
            novo.setAnterior(atual);
        }
    }

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T value) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(value);
        novo.setProximo(primeiro); // aponta o antigo primeiro
        primeiro = novo; // novo passa a ser o primeiro
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T value) {
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(value)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T value) {
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiro;

        while (atual != null && !atual.getInfo().equals(value)) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (anterior == null) {
                primeiro = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> atual = primeiro;

        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public NoLista<T> obterNo(int position) {
        if (position < 0 || position >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Posição Inválida!");
        }

        NoLista<T> atual = primeiro;
        int contador = 0;

        while (contador < position) {
            atual = atual.getProximo();
            contador++;
        }

        return atual;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null)
                sb.append(",");
            atual = atual.getProximo();
        }
        return sb.toString();
    }

}

/*
 
 */
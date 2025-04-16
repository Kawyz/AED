package com.kawanna;

@SuppressWarnings("unchecked")//remove as ondinhas de aviso
public class ListaEstatica<T> {
    
    private T[] info;
    private int tamanho;

    public ListaEstatica() {
        info = (T[]) new Object[10]; 
        tamanho = 0; 
    }

    public void redimensionar() { 
        T[] novo = (T[]) new Object[info.length + 10]; 
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i]; 
        }
        info = novo;
    }

    public void inserir(T value) { 
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = value;
        tamanho++;
    }

    public void exibir() { 
        for (int i = 0; i < tamanho; i++) {
            System.out.print(info[i] + " "); 
        }
        System.out.println();
    }

    public int buscar(T value) { 
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T value) { 
        int position = buscar(value);
        if (position != -1) {
            for (int i = position; i < tamanho - 1; i++) {
                info[i] = info[i + 1]; 
            }
            tamanho--; 
        }
    }

    public void liberar() { 
        info = (T[]) new Object[10];
        tamanho = 0; 
    }

    public T obterElemento(int position) { 
        if (position < 0 || position >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida!"); 
        }
        return info[position];
    }

    public boolean estaVazia() { 
        return tamanho == 0;
    }

    public int getTamanho() { 
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) sb.append(",");
        }
        return sb.toString();
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            T temp = info[i];
            info[i] = info[tamanho - 1 - i];
            info[tamanho - 1 - i] = temp;
        }
    }
}

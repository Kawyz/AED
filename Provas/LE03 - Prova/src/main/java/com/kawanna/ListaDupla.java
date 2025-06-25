package com.kawanna;

public class ListaDupla<T> {
    
    private NoListaDupla<T> primeiro; 

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);

        if (atual != null) {
            NoListaDupla<T> anterior = atual.getAnterior();
            NoListaDupla<T> proximo = atual.getProximo();

            if (anterior != null) {
                anterior.setProximo(proximo);
            } else {
                primeiro = proximo;
            }

            if (proximo != null) {
                proximo.setAnterior(anterior);
            }

            atual.setProximo(null);
            atual.setAnterior(null);
        } 
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = primeiro;

        if (atual == null) return;

        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        while (atual != null) {
            System.out.println(atual.getInfo() + " ");
            atual = atual.getAnterior();
        }

        System.out.println();
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
            atual = proximo;
        }
        primeiro = null;
    }

    public ListaDupla<T> clonar() {
        ListaDupla<T> copia = new ListaDupla<>();
    
        NoListaDupla<T> atual = primeiro;
    
        while (atual != null) {
            copia.inserirFim(atual.getInfo());
            atual = atual.getProximo();
        }
    
        return copia;
    }

    //Metdo adicionado para inserir os valores na ordem correta
    public void inserirFim(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
    
        if (primeiro == null) {
            primeiro = novo;
        } else {
            NoListaDupla<T> atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
            novo.setAnterior(atual);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) sb.append(",");
            atual = atual.getProximo();
        }

        return sb.toString();
    }

}



//Método inserirFim
 /* Início
  ↓
Criar novo nó com valor
  ↓
[primeiro == null?]
    ├── Sim → `primeiro = novo`
    └── Não → 
        ↓
        `atual = primeiro`
        ↓
        [Enquanto atual.getProximo() ≠ null]
            └── atual = atual.getProximo()
        ↓
        atual.setProximo(novo)
        novo.setAnterior(atual)
  ↓
Fim
 */
package com.kawanna;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinaria<T> {

    public void inserir(T valor) {
        setRaiz(inserirRec(getRaiz(), valor));
    }

    private NoArvoreBinaria<T> inserirRec(NoArvoreBinaria<T> no, T valor) {
        if (no == null) {
            return new NoArvoreBinaria<>(valor);
        }
        if (valor.compareTo(no.getInfo()) < 0) {
            no.setEsquerda(inserirRec(no.getEsquerda(), valor));
        } else {
            no.setDireita(inserirRec(no.getDireita(), valor));
        }
        return no;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T valor) {
        return buscarRec(getRaiz(), valor);
    }

    private NoArvoreBinaria<T> buscarRec(NoArvoreBinaria<T> no, T valor) {
        if (no == null || valor.equals(no.getInfo())) {
            return no;
        }
        if (valor.compareTo(no.getInfo()) < 0) {
            return buscarRec(no.getEsquerda(), valor);
        } else {
            return buscarRec(no.getDireita(), valor);
        }
    }

    public void retirar(T valor) {
        setRaiz(retirarRec(getRaiz(), valor));
    }

    private NoArvoreBinaria<T> retirarRec(NoArvoreBinaria<T> no, T valor) {
        if (no == null) return null;

        if (valor.compareTo(no.getInfo()) < 0) {
            no.setEsquerda(retirarRec(no.getEsquerda(), valor));
        } else if (valor.compareTo(no.getInfo()) > 0) {
            no.setDireita(retirarRec(no.getDireita(), valor));
        } else {

            // caso 1: sem filhos
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }
            
            // caso 2: só um filho
            else if (no.getEsquerda() == null) {
                return no.getDireita();
            } else if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            // caso 3: dois filhos
            else {
                NoArvoreBinaria<T> substituto = encontrarMinimo(no.getDireita());
                no.setInfo(substituto.getInfo());
                no.setDireita(retirarRec(no.getDireita(), substituto.getInfo()));
            }
        }
        return no;
    }

    private NoArvoreBinaria<T> encontrarMinimo(NoArvoreBinaria<T> no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}

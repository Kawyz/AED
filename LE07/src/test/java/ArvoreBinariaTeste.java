import org.junit.jupiter.api.Test;

import com.kawanna.ArvoreBinaria;
import com.kawanna.NoArvoreBinaria;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaTeste {

    private ArvoreBinaria<Integer> construirArvoreCompleta() {
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>();
        n1.setInfo(1);

        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>();
        n2.setInfo(2);

        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>();
        n3.setInfo(3);

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>();
        n4.setInfo(4);

        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>();
        n5.setInfo(5);

        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>();
        n6.setInfo(6);

        n1.setEsquerdo(n2);
        n1.setDireito(n3);

        n2.setEsquerdo(n4);
        n3.setEsquerdo(n5);
        n3.setDireito(n6);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(n1);

        return arvore;
    }

    @Test // 1
    public void testArvoreVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        assertTrue(arvore.estaVazia());
    }

    @Test // 2
    public void testArvoreNaoVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>();
        raiz.setInfo(5);
        arvore.setRaiz(raiz);

        assertFalse(arvore.estaVazia());
    }

    @Test // 3
    public void testToStringPreOrdem() {
        // Cria os nós
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>();
        n1.setInfo(1);

        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>();
        n2.setInfo(2);

        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>();
        n3.setInfo(3);

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>();
        n4.setInfo(4);

        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>();
        n5.setInfo(5);

        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>();
        n6.setInfo(6);

        // Liga os nós
        n1.setEsquerdo(n2);
        n1.setDireito(n3);

        n2.setEsquerdo(n4);

        n3.setEsquerdo(n5);
        n3.setDireito(n6);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(n1);

        assertEquals("<1<2<4<><>><><3<5<><>><6<><>>>>", arvore.toString());
    }

    @Test // 4
    public void testPertenceRaiz() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>();
        raiz.setInfo(1);
        arvore.setRaiz(raiz);

        assertTrue(arvore.pertence(1));
    }

    @Test // 5
    public void testPertenceNoInterno() {
        ArvoreBinaria<Integer> arvore = construirArvoreCompleta();
        assertTrue(arvore.pertence(3));
    }

    @Test // 6
    public void testPertenceFolha() {
        ArvoreBinaria<Integer> arvore = construirArvoreCompleta();
        assertTrue(arvore.pertence(6));
    }

    @Test // 7
    public void testValorNaoPertence() {
        ArvoreBinaria<Integer> arvore = construirArvoreCompleta();
        assertFalse(arvore.pertence(10));
    }

    @Test // 8
    public void testContarNos() {
        ArvoreBinaria<Integer> arvore = construirArvoreCompleta();
        assertEquals(6, arvore.contarNos());
    }

}

import com.kawanna.Arvore;
import com.kawanna.NoArvore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArvoreNAriaTest {
    private Arvore<Integer> construirArvoreExemplo() {
        
        // Cria os nós
        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n10 = new NoArvore<>(10);

        // Monta filhos
        n2.inserirFilho(n5);
        n2.inserirFilho(n6);
        n2.inserirFilho(n7);

        n3.inserirFilho(n8);

        n4.inserirFilho(n9);
        n4.inserirFilho(n10);

        n1.inserirFilho(n2);
        n1.inserirFilho(n3);
        n1.inserirFilho(n4);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        return arvore;
    }

    @Test //1
    public void testToString() {
        Arvore<Integer> arvore = construirArvoreExemplo();
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test //2
    public void testPertenceValorExistente() {
        Arvore<Integer> arvore = construirArvoreExemplo();
        assertTrue(arvore.pertence(7));
    }

    @Test //3
    public void testPertenceValorInexistente() {
        Arvore<Integer> arvore = construirArvoreExemplo();
        assertFalse(arvore.pertence(55));
    }

    @Test //4
    public void testContarNos() {
        Arvore<Integer> arvore = construirArvoreExemplo();
        assertEquals(10, arvore.contarNos());
    }
}


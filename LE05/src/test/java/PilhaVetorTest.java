import org.junit.jupiter.api.Test;

import com.kawanna.PilhaVetor;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaVetorTest {

    @Test //1
    public void testPush() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals("30,20,10", pilha.toString());
    }

    @Test //2
    public void testPeek() {
        PilhaVetor<String> pilha = new PilhaVetor<>(3);
        pilha.push("A");
        pilha.push("B");

        assertEquals("B", pilha.peek());
        assertEquals("B,A", pilha.toString()); // pilha não muda com peek
    }

    @Test //3
    public void testPop() {
        PilhaVetor<String> pilha = new PilhaVetor<>(3);
        pilha.push("A");
        pilha.push("B");

        assertEquals("B", pilha.pop());
        assertEquals("A", pilha.peek());
    }

    @Test //4
    public void testEstaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(2);

        assertTrue(pilha.estaVazia());

        pilha.push(1);

        assertFalse(pilha.estaVazia());
    }

    @Test //5
    public void testLiberar() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(4);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        assertTrue(pilha.estaVazia());
        assertEquals("", pilha.toString());
    }

    @Test //6
    public void testConcatenar() {
        PilhaVetor<Integer> p1 = new PilhaVetor<>(3);
        p1.push(1);
        p1.push(2);

        PilhaVetor<Integer> p2 = new PilhaVetor<>(3);
        p2.push(3);
        p2.push(4);

        PilhaVetor<Integer> resultado = p1.concatenar(p2);

        //ordem: p1 (2,1) + p2 (4,3) → 4,3,2,1
        assertEquals("4,3,2,1", resultado.toString());

        //originais não devem ser alteradas
        assertEquals("2,1", p1.toString());
        assertEquals("4,3", p2.toString());
    }

    @Test //7
    public void testPushComPilhaCheia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(2);
        pilha.push(1);
        pilha.push(2);

        assertThrows(IllegalStateException.class, () -> {
            pilha.push(3);
        });
    }
 
    @Test //8
    public void testPopComPilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(2);

        assertThrows(IllegalStateException.class, () -> {
            pilha.pop();
        });
    }


    @Test //9
    public void testPeekComPilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(2);

        assertThrows(IllegalStateException.class, () -> {
            pilha.peek();
        });
    }
}

import org.junit.jupiter.api.Test;

import com.kawanna.PilhaLista;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {

    @Test //1
    public void testPush() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals("30,20,10", pilha.toString());
    }

    @Test //2
    public void testPeek() {
        PilhaLista<String> pilha = new PilhaLista<>();
        pilha.push("A");
        pilha.push("B");

        assertEquals("B", pilha.peek());
        assertEquals("B,A", pilha.toString());
    }

    @Test //3
    public void testPop() {
        PilhaLista<String> pilha = new PilhaLista<>();
        pilha.push("A");
        pilha.push("B");

        assertEquals("B", pilha.pop());
        assertEquals("A", pilha.peek());
        assertEquals("A", pilha.toString());
    }

    @Test //4
    public void testEstaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        assertTrue(pilha.estaVazia());

        pilha.push(1);
        assertFalse(pilha.estaVazia());

        pilha.pop();
        assertTrue(pilha.estaVazia());
    }

    @Test //5
    public void testLiberar() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        assertTrue(pilha.estaVazia());
        assertEquals("", pilha.toString());
    }

    @Test //6
    public void testPeekComPilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        assertThrows(IllegalStateException.class, () -> {
            pilha.peek();
        });
    }

    @Test //7
    public void testPopComPilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        assertThrows(IllegalStateException.class, () -> {
            pilha.pop();
        });
    }

}

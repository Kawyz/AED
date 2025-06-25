import org.junit.jupiter.api.Test;

import com.kawanna.FilaCheiaException;
import com.kawanna.FilaVaziaException;
import com.kawanna.FilaVetor;

import static org.junit.jupiter.api.Assertions.*;

public class FilaVetorTest {

    @Test // 1
    public void testInsercao() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals("10,20,30", fila.toString());
    }

    @Test // 2
    public void testRetirada() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals("20,30", fila.toString());
    }

    @Test // 3
    public void testPeek() {
        FilaVetor<String> fila = new FilaVetor<>(3);
        fila.inserir("A");
        fila.inserir("B");

        assertEquals("A", fila.peek());
        assertEquals("A,B", fila.toString()); // fila continua igual
    }

    @Test // 4
    public void testEstaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(2);

        assertTrue(fila.estaVazia());

        fila.inserir(5);
        assertFalse(fila.estaVazia());
    }

    @Test // 5
    public void testLiberar() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(1);
        fila.inserir(2);

        fila.liberar();

        assertTrue(fila.estaVazia());
        assertEquals("", fila.toString());
    }

    @Test // 6
    public void testGetLimite() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);

        assertEquals(10, fila.getLimite());
    }

    @Test // 7
    public void testCriarFilaConcatenada() {
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        f1.inserir(1);
        f1.inserir(2);

        FilaVetor<Integer> f2 = new FilaVetor<>(5);
        f2.inserir(3);
        f2.inserir(4);

        FilaVetor<Integer> f3 = f1.criarFilaConcatenada(f2);

        assertEquals("1,2,3,4", f3.toString());
        assertEquals("1,2", f1.toString()); // original inalterada
        assertEquals("3,4", f2.toString()); // original inalterada
    }

    @Test // 8
    public void testFilaCheiaException() {
        FilaVetor<Integer> fila = new FilaVetor<>(2);
        fila.inserir(1);
        fila.inserir(2);

        assertThrows(FilaCheiaException.class, () -> {
            fila.inserir(3);
        });
    }

    @Test // 9
    public void testFilaVaziaExceptionPeek() {
        FilaVetor<Integer> fila = new FilaVetor<>(2);

        assertThrows(FilaVaziaException.class, () -> {
            fila.peek();
        });
    }

    @Test // 10
    public void testFilaVaziaExceptionRetirar() {
        FilaVetor<Integer> fila = new FilaVetor<>(2);

        assertThrows(FilaVaziaException.class, () -> {
            fila.retirar();
        });
    }

}

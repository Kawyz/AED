import org.junit.jupiter.api.Test;
import com.kawanna.FilaLista;
import com.kawanna.FilaVaziaException;
import static org.junit.jupiter.api.Assertions.*;

public class FilaListaTest {

    @Test // 1
    public void testFilaVaziaAoCriar() {
        FilaLista<Integer> fila = new FilaLista<>();
        assertTrue(fila.estaVazia());
    }

    @Test // 2
    public void testFilaNaoVazia() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test // 3
    public void testInserirERetirar() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test // 4
    public void testPeek() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);

        assertEquals(10, fila.peek()); // Não remove
        assertEquals(10, fila.retirar()); // Agora sim remove
    }

    @Test // 5
    public void testLiberar() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();

        assertTrue(fila.estaVazia());
        assertThrows(FilaVaziaException.class, fila::peek);
    }

}

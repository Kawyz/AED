import org.junit.jupiter.api.Test;
import com.kawanna.ListaOrdenada;
import static org.junit.jupiter.api.Assertions.*;

class ListaOrdenadaTest {

    @Test
    void testeInsercaoOrdenada() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(100);
        lista.inserir(20);
        lista.inserir(70);
        lista.inserir(1);

        assertEquals("1,20,70,100", lista.toString());
    }

    @Test
    void testeBuscar20() {
        ListaOrdenada<Integer> lista = construirListaCompleta();
        assertEquals(2, lista.buscar(20));
    }

    @Test
    void testeBuscar40() {
        ListaOrdenada<Integer> lista = construirListaCompleta();
        assertEquals(4, lista.buscar(40));
    }

    @Test
    void testeBuscar70() {
        ListaOrdenada<Integer> lista = construirListaCompleta();
        assertEquals(7, lista.buscar(70));
    }

    @Test
    void testeBuscar100() {
        ListaOrdenada<Integer> lista = construirListaCompleta();
        assertEquals(10, lista.buscar(100));
    }

    @Test
    void testeBuscarInexistente() {
        ListaOrdenada<Integer> lista = construirListaCompleta();
        assertEquals(-1, lista.buscar(85));
    }

    // Método auxiliar
    private ListaOrdenada<Integer> construirListaCompleta() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        for (int i = 0; i <= 100; i += 10) {
            lista.inserir(i);
        }
        return lista;
    }
}

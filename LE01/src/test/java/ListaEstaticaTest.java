import org.junit.jupiter.api.Test;

import com.kawanna.ListaEstatica;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEstaticaTest {
    
    @Test
    public void testInsercao() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    @Test
    public void testGetTamanho() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    @Test
    public void testBuscarElementoExistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));
    }

    @Test
    public void testBuscarElementoInexistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test
    public void testRetirarElemento() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5,15,20", lista.toString());
        assertEquals(3, lista.getTamanho());
    }

    @Test
    public void testRedimensionamento() {
        ListaEstatica lista = new ListaEstatica();
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }

        assertEquals(15, lista.getTamanho());
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
    }

    @Test
    public void testObterElemento() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterElemento(3));
    }

    @Test
    public void testObterElementoInvalido() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterElemento(5);
        });
    }

    @Test
    public void testLiberarLista() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
    }
}

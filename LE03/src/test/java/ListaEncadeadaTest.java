import org.junit.jupiter.api.Test;

import com.kawanna.ListaEncadeada;
import com.kawanna.NoLista;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEncadeadaTest {
    
    @Test //01
    public void testListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        assertTrue(lista.estaVazia());
    }

    @Test //02
    public void testListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);

        assertFalse(lista.estaVazia());
    }

    @Test //03
    public void testInserirValorUnico() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);

        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(5, primeiro.getInfo());
        assertNotNull(primeiro.getProximo());
    }

    @Test //04
    public void testInserirTresValores() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        assertEquals(3, lista.obterComprimento());
        assertEquals(15, lista.getPrimeiro().getInfo());
        assertEquals(10, lista.getPrimeiro().getProximo().getInfo());
        assertEquals(5, lista.getPrimeiro().getProximo().getProximo().getInfo());
    }

    @Test //05
    public void testBuscarPrimeiro() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(20);
        assertNotNull(resultado);
        assertEquals(20, resultado.getInfo());
    }

    @Test //06
    public void testBuscarMeio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(15);
        assertNotNull(resultado);
        assertEquals(15, resultado.getInfo());
    }

    @Test //07
    public void testBuscarInexistente() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(50);
        assertNull(resultado);
    }

    @Test //08
    public void testRetirarPrimeiro() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        assertEquals("15,10,5", lista.toString());
    }

    @Test //09
    public void testRetirarMeio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);

        assertEquals("20,10,5", lista.toString());
    }

    @Test //10
    public void testObterNoZero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(0);
        assertEquals(20, no.getInfo());
    }

    @Test //11
    public void testObterNoUltimo() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(3);
        assertEquals(5, no.getInfo());
    }

    @Test //12
    public void testObterNoInvalido() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterNo(10);
        });
    }

    @Test //13
    public void testComprimentoListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        assertEquals(0, lista.obterComprimento());
    }

    @Test //14
    public void testComprimentoListaCheia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.obterComprimento());
    }
}

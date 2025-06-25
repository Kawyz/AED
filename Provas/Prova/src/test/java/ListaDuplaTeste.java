import com.kawanna.ListaDupla;
import com.kawanna.NoListaDupla;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplaTeste {
    
    @Test //1
    public void testInsercao() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        assertEquals(20, atual.getInfo());
        assertEquals(15, atual.getProximo().getInfo());
        assertEquals(10, atual.getProximo().getProximo().getInfo());
        assertEquals(5, atual.getProximo().getProximo().getProximo().getInfo());
        assertNull(atual.getProximo().getProximo().getProximo().getProximo());

        NoListaDupla<Integer> ultimo = atual;
        while (ultimo.getProximo() != null) {
            ultimo = ultimo.getProximo();
        }

        assertEquals(5, ultimo.getInfo());
        assertEquals(10, ultimo.getAnterior().getInfo());
        assertEquals(15, ultimo.getAnterior().getAnterior().getInfo());
        assertEquals(20, ultimo.getAnterior().getAnterior().getAnterior().getInfo());
        assertNull(ultimo.getAnterior().getAnterior().getAnterior().getAnterior());
    }

    @Test //2
    public void testBuscarInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertEquals(20, no.getInfo());
    }

    @Test //3
    public void testBuscarMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no = lista.buscar(10);
        assertNotNull(no);
        assertEquals(10, no.getInfo());
    }

    @Test //4
    public void testRemoverNoInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        String esperado = "15,10,5";
        assertEquals(esperado, lista.toString());

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        assertEquals(5, atual.getInfo());
        assertEquals(10, atual.getAnterior().getInfo());
        assertEquals(15, atual.getAnterior().getAnterior().getInfo());
        assertNull(atual.getAnterior().getAnterior().getAnterior());
    }

    @Test //5
    public void testRemoverNoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("20,15,5", lista.toString());

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        assertEquals(5, atual.getInfo());
        assertEquals(15, atual.getAnterior().getInfo());
        assertEquals(20, atual.getAnterior().getAnterior().getInfo());
    }

    @Test //6
    public void testRemoverNoFim() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        assertEquals("20,15,10", lista.toString());

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        assertEquals(10, atual.getInfo());
        assertEquals(15, atual.getAnterior().getInfo());
        assertEquals(20, atual.getAnterior().getAnterior().getInfo());
    }

    @Test //7
    public void testLiberarDadosDaLista() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        //Antes de liberar
        NoListaDupla<Integer> no1 = lista.buscar(5);
        NoListaDupla<Integer> no2 = lista.buscar(10);
        NoListaDupla<Integer> no3 = lista.buscar(15);
        NoListaDupla<Integer> no4 = lista.buscar(20);

        //Dps de liberar
        lista.liberar();

        assertNull(lista.getPrimeiro());

        assertNull(no1.getAnterior());
        assertNull(no1.getProximo());

        assertNull(no2.getAnterior());
        assertNull(no2.getProximo());

        assertNull(no3.getAnterior());
        assertNull(no3.getProximo());

        assertNull(no4.getAnterior());
        assertNull(no4.getProximo());
    }

}

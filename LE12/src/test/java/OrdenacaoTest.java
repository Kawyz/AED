import org.junit.jupiter.api.Test;
import com.kawanna.OrdenacaoBolha;
import com.kawanna.OrdenacaoBolhaOtimizada;
import com.kawanna.OrdenacaoMergeSort;
import com.kawanna.OrdenacaoQuickSort;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class OrdenacaoTest {

    private final int[] entrada = {70, 2, 88, 15, 90, 30};
    private final int[] esperado = {2, 15, 30, 70, 88, 90};

    @Test //1
    public void testOrdenacaoBolha() {
        int[] vetor = Arrays.copyOf(entrada, entrada.length);
        OrdenacaoBolha ordenacao = new OrdenacaoBolha(vetor);
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }

    @Test //2
    public void testOrdenacaoBolhaOtimizada() {
        int[] vetor = Arrays.copyOf(entrada, entrada.length);
        OrdenacaoBolhaOtimizada ordenacao = new OrdenacaoBolhaOtimizada(vetor);
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }

    @Test //3
    public void testOrdenacaoQuickSort() {
        int[] vetor = Arrays.copyOf(entrada, entrada.length);
        OrdenacaoQuickSort ordenacao = new OrdenacaoQuickSort(vetor);
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }

    @Test //4
    public void testOrdenacaoMergeSort() {
        int[] vetor = Arrays.copyOf(entrada, entrada.length);
        OrdenacaoMergeSort ordenacao = new OrdenacaoMergeSort(vetor);
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }
}

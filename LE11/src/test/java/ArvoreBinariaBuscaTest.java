import org.junit.jupiter.api.Test;
import com.kawanna.ArvoreBinariaBusca;
import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaBuscaTest {

    @Test
    public void testeInsercaoMantemABB() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        int[] dados = {50, 30, 70, 40, 25, 75, 65, 35, 60};

        for (int valor : dados) {
            arvore.inserir(valor);
        }

        String esperado = "<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>";
        assertEquals(esperado, arvore.toString());
    }

    @Test
    public void testeRemoverNoFolha() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        int[] dados = {50, 30, 25, 40};

        for (int valor : dados) {
            arvore.inserir(valor);
        }

        arvore.retirar(40);

        String esperado = "<50<30<25<><>><>>>";
        assertEquals(esperado, arvore.toString());
    }

    @Test
    public void testeRemoverNoComUmFilho() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        int[] dados = {80, 52, 90, 48, 71, 63, 67};

        for (int valor : dados) {
            arvore.inserir(valor);
        }

        arvore.retirar(71);

        String esperado = "<80<52<48<><>><63<><67<><>>>><90<><>>>";
        assertEquals(esperado, arvore.toString());
    }

    @Test
    public void testeRemoverNoComDoisFilhos() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        int[] dados = {250, 38, 26, 72, 55, 90, 41, 60, 43, 78, 92, 74};

        for (int valor : dados) {
            arvore.inserir(valor);
        }

        arvore.retirar(38);

        String esperado = "<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>";
        assertEquals(esperado, arvore.toString());
    }
}

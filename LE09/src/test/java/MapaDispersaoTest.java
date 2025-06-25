import com.kawanna.Aluno;
import com.kawanna.MapaDispersao;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapaDispersaoTest {

    @Test // 1
    public void testInserirEBuscarUmAluno() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(jean.getMatricula(), jean);

        Aluno resultado = mapa.buscar(12000);

        assertSame(jean, resultado);
    }

    @Test //2
    public void testInserirVariosAlunosEBuscar() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno pedro = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno marta = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno lucas = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(jean.getMatricula(), jean);
        mapa.inserir(pedro.getMatricula(), pedro);
        mapa.inserir(marta.getMatricula(), marta);
        mapa.inserir(lucas.getMatricula(), lucas);

        assertSame(jean, mapa.buscar(12000));
        assertSame(pedro, mapa.buscar(14000));
        assertSame(marta, mapa.buscar(12500));
        assertSame(lucas, mapa.buscar(13000));
    }

    @Test //3
    public void testInserirComColisoesEBuscar() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));    // hash = 12000 % 53 = 41
        Aluno pedro = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20)); // hash = 14000 % 53 = 20
        Aluno marta = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18)); // hash = 14226 % 53 = 41 (colide com Jean)
        Aluno lucas = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));// hash = 17180 % 53 = 20 (colide com Pedro)

        mapa.inserir(jean.getMatricula(), jean);
        mapa.inserir(pedro.getMatricula(), pedro);
        mapa.inserir(marta.getMatricula(), marta);
        mapa.inserir(lucas.getMatricula(), lucas);

        assertSame(jean, mapa.buscar(12000));
        assertSame(pedro, mapa.buscar(14000));
        assertSame(marta, mapa.buscar(14226));
        assertSame(lucas, mapa.buscar(17180));
    }
}



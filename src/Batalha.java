import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Batalha {

    private Personagem usuario;
    private ArrayList<Personagem> inimigos;

    /*Método para determinar a ordem dos turnos.*/

    public List<Personagem> ordemTurno(Personagem inimigo) {
        List<Personagem> personagens = new ArrayList<>();
        personagens.add(usuario);
        personagens.add(inimigo);

        /*A ordem será escolhida de acordo com a força do personagem*/
        Collections.sort(personagens, new Comparator<Personagem>() {
            @Override
            public int compare(Personagem p1, Personagem p2) {
                return Integer.compare(p2.getForca(), p1.getForca());
            }
        });

        return personagens;
    }
}

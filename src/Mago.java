import java.util.ArrayList;

/**
 * Represents a Mago character in the game.
 * Extends the Personagem class.
 */
public class Mago extends Personagem {
    private int pontosMagia;

    /**
     * Constructor for Mago class.
     *
     * @param nome        The name of the Mago.
     * @param vida        The initial vida of the Mago.
     * @param forca       The initial forca of the Mago.
     * @param defesa      The initial defesa of the Mago.
     * @param pontosMagia The initial magical points of the Mago.
     */
    public Mago(String nome, int vida, int forca, int defesa, int pontosMagia) {
        super(nome, vida, forca, defesa);
        this.pontosMagia = pontosMagia;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Escudo Mágico", "Mágico", 0));
        habilidades.add(new Habilidade("Hipnose", "Mágico", 0));
    }
    /*Getter and Setter*/

    /**
     * Getter for pontosMagia.
     *
     * @return The magical points of the Mago.
     */
    public int getPontosMagia() {
        return pontosMagia;
    }

    /**
     * Setter for pontosMagia.
     *
     * @param pontosMagia The new magical points of the Mago.
     */
    public void setPontosMagia(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }


    /**
     * Overrides the atacar method from the Personagem class.
     * The Mago attacks the target with a dano equal to its forca plus its magical points.
     * There is a 20% chance of a critical hit, which doubles the dano.
     *
     * @param alvo The target of the attack.
     */
    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca + this.pontosMagia;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.receberDano(dano);
    }

    /**
     * Overrides the usarHabilidade method from the Personagem class.
     * The Mago uses a skill based on the index provided.
     *
     * @param indice The index of the skill to be used.
     * @param alvo The target of the skill.
     */
    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*Cria um escudo mágico que reduz o dano recebido pelo Mago em 80% por 3 turnos*/
        if (habilidade.getNome().equals("Escudo Mágico")) {
            alvo.calcularDano(dano);
            /*Escudo mágico reduz o dano recebido em 80% por 3 turnos*/


        }
        /*O mago hipnotisa o inimigo e ele fico inoperante por 3 turnos*/
        else if (habilidade.getNome().equals("Hipnose")) {
            alvo.calcularDano(dano);
            /*Alvo dorme por 3 turnos*/
            alvo.setDormindo(true);
        }
    }
}

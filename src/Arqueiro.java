import java.util.ArrayList;

/**
 * Arqueiro class extends Personagem and represents a character with archery skills.
 */
public class Arqueiro extends Personagem {
    private int destrezaComArco;


    /**
     * Constructor for Arqueiro class.
     *
     * @param nome            Name of the Arqueiro.
     * @param vida            Initial life points of the Arqueiro.
     * @param forca           Strength of the Arqueiro.
     * @param defesa          Defense of the Arqueiro.
     * @param destrezaComArco Archery skill of the Arqueiro.
     */
    public Arqueiro(String nome, int vida, int forca, int defesa, int destrezaComArco) {
        super(nome, vida, forca, defesa);
        this.destrezaComArco = destrezaComArco;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Chuva de Flechas", "Físico", 40));
        habilidades.add(new Habilidade("Tiro Flamejante", "Fogo", 20));

    }

    /*Getter and Setter*/

    /**
     * Getter for destrezaComArco attribute.
     *
     * @return The archery skill of the Arqueiro.
     */
    public int getDestrezaComArco() {
        return destrezaComArco;
    }
    /**
     * Setter for destrezaComArco attribute.
     *
     * @param destrezaComArco The new archery skill of the Arqueiro.
     */
    public void setDestrezaComArco(int destrezaComArco) {
        this.destrezaComArco = destrezaComArco;
    }


    /*Other Methods*/
    /**
     * Overridden method to perform a basic attack on the target Personagem.
     *
     * @param alvo The target Personagem.
     */
    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca + this.destrezaComArco;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.receberDano(dano);
    }

    /**
     * Overridden method to use a skill on the target Personagem.
     *
     * @param indice The index of the skill to be used.
     * @param alvo   The target Personagem.
     */
    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*Ataque em que arqueiro dispara uma série de flechas que atingem o inimigo, causando dano a várias partes do seu corpo*/
        if (habilidade.getNome().equals("Chuva de Flechas")) alvo.calcularDano(dano);

            /*Ataque em que o arqueiro dispara uma flecha com a ponta flamejante, o inimigo ficará queimado por mais dois turnos*/
        else if (habilidade.getNome().equals("Tiro Flamejante")) {
            alvo.calcularDano(dano);
            /*Queimar alvo por dois turnos*/
            alvo.setQueimado(true);
        }

    }
}

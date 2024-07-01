import java.util.ArrayList;
/**
 * This class represents a warrior character in the game.
 * It extends the Personagem class and adds specific attributes and methods for the warrior.
 */
public class Guerreiro extends Personagem {
    private int espadadaJusticeira;

    /**
     * Constructor for the Guerreiro class.
     *
     * @param nome The name of the warrior.
     * @param vida The initial health points of the warrior.
     * @param forca The strength of the warrior.
     * @param defesa The defense of the warrior.
     * @param espadadaJusticeira The warrior's special attack power.
     */
    /*Constructor*/
    public Guerreiro(String nome, int vida, int forca, int defesa, int espadadaJusticeira) {
        super(nome, vida, forca, defesa);
        this.espadadaJusticeira = espadadaJusticeira;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Fúria do Guerreiro", "Físico", 50));
        habilidades.add(new Habilidade("Punho de Prata", "Físico", 25));
    }

    /*Getter and Setter*/

    /**
     * Getter for the espadadaJusticeira attribute.
     *
     * @return The warrior's special attack power.
     */
    public int getEspadadaJusticeira() {
        return espadadaJusticeira;
    }

    /**
     * Setter for the espadadaJusticeira attribute.
     *
     * @param espadadaJusticeira The new value for the warrior's special attack power.
     */
    public void setEspadadaJusticeira(int espadadaJusticeira) {
        this.espadadaJusticeira = espadadaJusticeira;
    }

    /**
     * The warrior attacks another character.
     * It calculates the damage based on its strength and special attack power,
     * and applies a 20% chance for a critical hit.
     *
     * @param alvo The character being attacked.
     */
    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca + this.espadadaJusticeira;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.receberDano(dano);
    }

    /**
     * The warrior uses a skill on another character.
     * It calculates the damage based on the skill's base damage,
     * and applies specific effects based on the skill's name.
     *
     * @param indice The index of the skill being used.
     * @param alvo The character being targeted by the skill.
     */
    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*O guerreiro usa sua fúria com combustível e acerta o inimigo em cheio, causando grande dano*/
        if (habilidade.getNome().equals("Fúria do Guerreiro")) alvo.calcularDano(dano);

        /*O guerreiro desfere um golpe que adordoa o seu inimigo por 1 turno*/
        else if (habilidade.getNome().equals("Punho de Prata")) {
            alvo.calcularDano(dano);
            /*Atordoa alvo por 1 turno*/
            alvo.setAtordoado(true);

        }
    }

}

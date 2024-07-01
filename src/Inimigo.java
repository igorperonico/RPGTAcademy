import java.util.ArrayList;

/**
 * Represents an enemy character in the game.
 */
public class Inimigo extends Personagem {
    private int recompensaXP;
    private String tipo;

    /**
     * Constructor for the Inimigo class.
     *
     * @param nome         The name of the enemy.
     * @param vida         The initial health points of the enemy.
     * @param forca        The strength of the enemy.
     * @param defesa       The defense of the enemy.
     * @param recompensaXP The experience points the player will receive after defeating this enemy.
     * @param tipo         The type of the enemy (e.g., Monstro, Comandante).
     */
    public Inimigo(String nome, int vida, int forca, int defesa, int recompensaXP, String tipo) {
        super(nome, vida, forca, defesa);
        this.recompensaXP = recompensaXP;
        this.tipo = tipo;
        this.habilidades = new ArrayList<>();
        if (tipo.equals("Monstro")) {
            habilidades.add(new Habilidade("Golpe Sombrio", "Sombra", 40));
            habilidades.add(new Habilidade("Rajada de Veneno", "Veneno", 15));
        } else if (tipo.equals("Comandante")) {
            habilidades.add(new Habilidade("Golpe Sombrio", "Sombra", 60));
            habilidades.add(new Habilidade("Rajada de Veneno", "Veneno", (int) 24));
        } else {
            habilidades.add(new Habilidade("Golpe Sombrio", "Sombra", 80));
            habilidades.add(new Habilidade("Rajada de Veneno", "Veneno", 30));
        }
    }

    /*Getter and Setter*/

    /**
     * Returns the experience points the player will receive after defeating this enemy.
     *
     * @return The experience points.
     */
    public int getRecompensaXP() {
        return recompensaXP;
    }

    /**
     * Sets the experience points the player will receive after defeating this enemy.
     *
     * @param recompensaXP The experience points.
     */
    public void setRecompensaXP(int recompensaXP) {
        this.recompensaXP = recompensaXP;
    }

    /**
     * Returns the type of the enemy (e.g., Monstro, Comandante).
     *
     * @return The type of the enemy.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the type of the enemy (e.g., Monstro, Comandante, Chefao).
     *
     * @param tipo The type of the enemy.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * The enemy attacks the target character.
     * If a critical hit occurs (20% chance), the damage is doubled.
     *
     * @param alvo The target character.
     */
    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.receberDano(dano);
    }

    /**
     * The enemy uses a skill on the target character.
     *
     * @param indice The index of the skill in the list of skills.
     * @param alvo   The target character.
     */
    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*Um ataque sombrio que drena a vida do alvo e cura o atacante por uma porcentagem do dano causado*/
        if (habilidade.getNome().equals("Fúria do Guerreiro")) {
            alvo.calcularDano(dano);
            int cura = (int) (dano * 0.2); // 20% de cura
            this.vida += cura;
        }

        /*Lança uma rajada venenosa que causa dano ao alvo ao longo de 3 turnos.*/
        else if (habilidade.getNome().equals("Rajada de Veneno")) {
            alvo.calcularDano(dano);
            /*Personagem envenenado ao longo de 3 turnos*/
            alvo.setEnvenenado(true);
        }

    }

}

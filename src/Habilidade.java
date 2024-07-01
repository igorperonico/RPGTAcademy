/**
 * Represents a character's skill or ability.
 */
public class Habilidade {
    private String nome;
    private String tipo;
    private int danoBase;

    /**
     * Constructor for the Habilidade class.
     *
     * @param nome      The name of the skill.
     * @param tipo      The type of the skill.
     * @param danoBase  The base damage of the skill.
     */
    public Habilidade(String nome, String tipo, int danoBase) {
        this.nome = nome;
        this.tipo = tipo;
        this.danoBase = danoBase;
    }

    /*Getter and Setter*/

    /**
     * Getter for the skill's name.
     *
     * @return The name of the skill.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter for the skill's name.
     *
     * @param nome The new name of the skill.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter for the skill's type.
     *
     * @return The type of the skill.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter for the skill's type.
     *
     * @param tipo The new type of the skill.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter for the skill's base damage.
     *
     * @return The base damage of the skill.
     */
    public int getDanoBase() {
        return danoBase;
    }

    /**
     * Setter for the skill's base damage.
     *
     * @param danoBase The new base damage of the skill.
     */
    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }
}

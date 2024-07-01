import java.util.List;

/**
 * Abstract class representing a character in the game.
 * It contains common attributes and methods for all characters.
 */
public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int forca;
    protected int defesa;
    protected boolean isDefendendo;
    protected List<Habilidade> habilidades;
    protected int experiencia;
    protected int nivel;
    protected boolean isEnvenenado;
    protected boolean isAtordoado;
    protected boolean isQueimado;
    protected boolean isDormindo;
    protected boolean isFugir;


    /**
     * Constructor for the Personagem class.
     *
     * @param nome   the name of the character
     * @param vida   the initial health points of the character
     * @param forca  the strength of the character
     * @param defesa the defense of the character
     */
    public Personagem(String nome, int vida, int forca, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.experiencia = 0;
        this.nivel = 1;
        this.isDefendendo = false;
        this.isEnvenenado = false;
        this.isAtordoado = false;
        this.isQueimado = false;
        this.isDormindo = false;
        this.isFugir = false;
    }
    /*Getter and Setters*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public boolean isDefendendo() {
        return isDefendendo;
    }

    public void setDefendendo(boolean defendendo) {
        isDefendendo = defendendo;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isEnvenenado() {
        return isEnvenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        isEnvenenado = envenenado;
    }

    public boolean isAtordoado() {
        return isAtordoado;
    }

    public void setAtordoado(boolean atordoado) {
        isAtordoado = atordoado;
    }

    public boolean isQueimado() {
        return isQueimado;
    }

    public void setQueimado(boolean queimado) {
        isQueimado = queimado;
    }

    public boolean isDormindo() {
        return isDormindo;
    }

    public void setDormindo(boolean dormindo) {
        isDormindo = dormindo;
    }

    public boolean isFugir() {
        return isFugir;
    }

    public void setFugir(boolean fugir) {
        isFugir = fugir;
    }

    /*Other Methods*/

    /**
     * Abstract method for the character to attack another character.
     *
     * @param inimigo the character being attacked
     */
    public abstract void atacar(Personagem inimigo);

    /**
     * Method for the character to defend itself.
     * The defense is doubled during defense.
     */
    public void defender() {
        this.isDefendendo = true;
        this.defesa *= 2;
    }

    public void removerDefesa() {
        this.isDefendendo = false;
        this.defesa /= 2;
    }

    /**
     * Method for the character to use a skill on another character.
     *
     * @param indice the index of the skill in the list of skills
     * @param alvo   the character being targeted by the skill
     */
    public abstract void usarHabilidade(int indice, Personagem alvo);

    /**
     * Method for the character to gain experience points.
     * If the experience points reach a certain threshold, the character's level increases.
     *
     * @param recompensaXP the experience points gained
     */
    public void adicionarXP(int recompensaXP) {
        this.experiencia += recompensaXP;
        if (this.experiencia >= this.nivel * 100) {
            this.nivel++;
            this.experiencia = 0;
            // Aumentar atributos ao subir de nível
            this.vidaMaxima += 30;
            this.vida = this.vidaMaxima;
            this.forca += 25;
            this.defesa += 10;
        }
    }

    /**
     * Method for the character to receive damage.
     * The damage is reduced by the character's defense.
     *
     * @param dano the amount of damage received
     */
    public void receberDano(int dano) {
        int danoRecebido = dano - this.defesa;
        this.vida -= (danoRecebido > 0) ? danoRecebido : 0;
        if (this.vida < 0) this.vida = 0;
    }

    /**
     * Method for calculating the damage received after using a special skill.
     * In this method, the enemy cannot use defense.
     *
     * @param dano the amount of damage to be subtracted from the character's health points
     * @return void
     * @since 1.0
     */
    public void calcularDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }


    /**
     * Method to check if the character is still alive.
     *
     * @return true if the character has more than 0 health points, false otherwise
     */
    public boolean isVivo() {
        return this.vida > 0;
    }
}

import java.util.List;

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


    /*Constructor*/
    public Personagem(String nome, int vida, int forca, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.experiencia = 0;
        this.nivel = 1;
        this.isDefendendo = false;
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

    /*Other Methods*/


    public abstract void atacar(Personagem inimigo);

    public void defender() {
        this.isDefendendo = true;
        this.defesa += defesa;
    }

    public void removerDefesa() {
        this.isDefendendo = false;
        this.defesa -= defesa;
    }

    public abstract void usarHabilidade(int indice, Personagem alvo);

    /*Adiciona XP (esperiência) ao personagem, o que pode elevar o nível de poder do mesmo*/
    public void adicionarXP(int recompensaXP) {
        this.experiencia += recompensaXP;
        if (this.experiencia >= this.nivel * 100) {
            this.nivel++;
            this.experiencia = 0;
            // Aumentar atributos ao subir de nível
            this.vidaMaxima += 50;
            this.vida = this.vidaMaxima;
            this.forca += 20;
            this.defesa += 20;
        }
    }

    /*Calcula o dano recebido de acordo com a defesa do personagem*/
    public void receberDano(int dano) {
        int danoRecebido = dano - this.defesa;
        this.vida -= (danoRecebido > 0) ? danoRecebido : 0;
        if (this.vida < 0) this.vida = 0;
    }



    /*Verificar se o personagem ainda está com pontos de vida*/
    public boolean isVivo() {
        return this.vida > 0;
    }
}

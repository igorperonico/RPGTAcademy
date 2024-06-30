import java.util.List;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int forca;
    protected int defesa;
    protected boolean isDefendendo;
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

    /*Other Methods*/


    public abstract void atacar(Personagem inimigo);

    public void defender() {
        this.isDefendendo = true;
        this.defesa += 10;
    }

    public void removerDefesa() {
        this.isDefendendo = false;
        this.defesa -= 10;
    }

    public void adicionarExp(int recompensaXP) {
        this.experiencia += recompensaXP;
        if (this.experiencia >= this.nivel * 100) {
            this.nivel++;
            this.experiencia = 0;
            // Aumentar atributos ao subir de nível
            this.vidaMaxima += 10;
            this.vida = this.vidaMaxima;
            this.forca += 2;
            this.defesa += 2;
        }
    }

    public void calcularDano(int dano) {
        int danoRecebido = dano - this.defesa;
        this.vida -= (danoRecebido > 0) ? danoRecebido : 0;
        if (this.vida < 0) this.vida = 0;
    }

    /*Verificar se o personagem ainda está com pontos de vida*/
    public boolean isVivo() {
        return this.vida > 0;
    }
}

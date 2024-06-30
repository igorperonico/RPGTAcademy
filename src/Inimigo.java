public class Inimigo extends Personagem {
    private int recompensaXP;
    private String tipo;

    /*Constructor*/
    public Inimigo(String nome, int vida, int forca, int defesa, int recompensaXP, String tipo) {
        super(nome, vida, forca, defesa);
        this.recompensaXP = recompensaXP;
        this.tipo = tipo;
    }
    /*Getter and Setter*/

    public int getRecompensaXP() {
        return recompensaXP;
    }

    public void setRecompensaXP(int recompensaXP) {
        this.recompensaXP = recompensaXP;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.calcularDano(dano);
    }
}

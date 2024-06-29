public class Arqueiro extends Personagem {
    private int destrezaComArco;

    /*Constructor*/
    public Arqueiro(String nome, int vida, int forca, int defesa, int destreza) {
        super(nome, vida, forca, defesa);
        this.destrezaComArco = destreza;
    }
    /*Getter and Setter*/

    public int getDestrezaComArco() {
        return destrezaComArco;
    }

    public void setDestrezaComArco(int destrezaComArco) {
        this.destrezaComArco = destrezaComArco;
    }

    public int usardestrezaComArco(Personagem inimigo){

        return (this.forca + this.destrezaComArco) - inimigo.defesa;
    }

    /*Methods*/
    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca + this.destrezaComArco;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.receberDano(dano);
    }
}

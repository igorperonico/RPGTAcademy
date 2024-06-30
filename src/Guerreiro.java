public class Guerreiro extends Personagem {
    private int espadadaJusticeira;

    /*Constructor*/
    public Guerreiro(String nome, int vida, int forca, int defesa, int espadadaJusticeira) {
        super(nome, vida, forca, defesa);
        this.espadadaJusticeira = espadadaJusticeira;
    }

    /*Getter and Setter*/

    public int getEspadadaJusticeira() {
        return espadadaJusticeira;
    }

    public void setEspadadaJusticeira(int espadadaJusticeira) {
        this.espadadaJusticeira = espadadaJusticeira;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca + this.espadadaJusticeira;
        if (Math.random() < 0.2) { // 20% de chance de golpe crítico
            dano *= 2;
            System.out.println("Golpe Crítico!");
        }
        alvo.calcularDano(dano);
    }

}

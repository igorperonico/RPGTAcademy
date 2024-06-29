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
}

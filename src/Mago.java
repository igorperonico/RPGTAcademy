public class Mago extends Personagem {
    private int pontosMagia;
    /*Constructor*/
    public Mago(String nome, int vida, int forca, int defesa, int pontosMagia) {
        super(nome, vida, forca, defesa);
        this.pontosMagia = pontosMagia;
    }
    /*Getter and Setter*/

    public int getPontosMagia() {
        return pontosMagia;
    }

    public void setPontosMagia(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }
}

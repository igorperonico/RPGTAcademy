import java.util.ArrayList;

public class Arqueiro extends Personagem {
    private int destrezaComArco;

    /*Constructor*/

    public Arqueiro(String nome, int vida, int forca, int defesa, int destrezaComArco) {
        super(nome, vida, forca, defesa);
        this.destrezaComArco = destrezaComArco;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Chuva de Flechas", "Físico", 40));
        habilidades.add(new Habilidade("Tiro Flamejante", "Fogo", 15));

    }

    /*Getter and Setter*/

    public int getDestrezaComArco() {
        return destrezaComArco;
    }

    public void setDestrezaComArco(int destrezaComArco) {
        this.destrezaComArco = destrezaComArco;
    }

    public int usardestrezaComArco(Personagem inimigo) {

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

    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*Ataque em que arqueiro dispara uma série de flechas que atingem o inimigo, causando dano a várias partes do seu corpo*/
        if (habilidade.getNome().equals("Chuva de Flechas")) alvo.receberDano(dano);

        /*Ataque em que o arqueiro dispara uma flecha com a ponta flamejante, o inimigo ficará queimado por mais dois turnos*/
        else if (habilidade.getNome().equals("Tiro Flamejante")) {
            alvo.receberDano(dano);
            /*Queimar alvo por dois turnos*/
        }

    }
}

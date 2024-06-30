import java.util.ArrayList;

public class Mago extends Personagem {
    private int pontosMagia;

    /*Constructor*/
    public Mago(String nome, int vida, int forca, int defesa, int pontosMagia) {
        super(nome, vida, forca, defesa);
        this.pontosMagia = pontosMagia;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Escudo Mágico", "Mágico", 0));
        habilidades.add(new Habilidade("Hipnose", "Mágico", 0));
    }
    /*Getter and Setter*/

    public int getPontosMagia() {
        return pontosMagia;
    }

    public void setPontosMagia(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }

    /*Methods*/
    @Override
    public void atacar(Personagem alvo) {
        int dano = this.forca + this.pontosMagia;
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
        /*Cria um escudo mágico que reduz o dano recebido pelo Mago em 80% por 3 turnos*/
        if (habilidade.getNome().equals("Escudo Mágico")) {
            alvo.receberDano(dano);
            /*Escudo mágico reduz o dano recebido em 80% por 3 turnos*/

        }
        /*O mago hipnotisa o inimigo e ele fico inoperante por 3 turnos*/
        else if (habilidade.getNome().equals("Hipnose")) {
            alvo.receberDano(dano);
            /*Alvo dorme por 3 turnos*/
        }
    }
}

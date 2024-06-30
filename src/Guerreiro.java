import java.util.ArrayList;

public class Guerreiro extends Personagem {
    private int espadadaJusticeira;

    /*Constructor*/
    public Guerreiro(String nome, int vida, int forca, int defesa, int espadadaJusticeira) {
        super(nome, vida, forca, defesa);
        this.espadadaJusticeira = espadadaJusticeira;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Fúria do Guerreiro", "Físico", 50));
        habilidades.add(new Habilidade("Punho de Prata", "Físico", 10));
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
        alvo.receberDano(dano);
    }

    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*O guerreiro usa sua fúria com combustível e acerta o inimigo em cheio, causando grande dano*/
        if (habilidade.getNome().equals("Fúria do Guerreiro")) alvo.receberDano(dano);

        /*O guerreiro desfere um golpe que adordoa o seu inimigo por dois turnos*/
        else if (habilidade.getNome().equals("Punho de Prata")) {
            alvo.receberDano(dano);
            /*Atordoa alvo por dois turnos*/
        }
    }

}

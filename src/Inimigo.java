import java.util.ArrayList;

public class Inimigo extends Personagem {
    private int recompensaXP;
    private String tipo;

    /*Constructor*/
    public Inimigo(String nome, int vida, int forca, int defesa, int recompensaXP, String tipo) {
        super(nome, vida, forca, defesa);
        this.recompensaXP = recompensaXP;
        this.tipo = tipo;
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Golpe Sombrio", "Sombra", 30));
        habilidades.add(new Habilidade("Rajada de Veneno", "Veneno", 15));
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
        alvo.receberDano(dano);
    }

    @Override
    public void usarHabilidade(int indice, Personagem alvo) {
        Habilidade habilidade = habilidades.get(indice);
        int dano = habilidade.getDanoBase();
        /*Um ataque sombrio que drena a vida do alvo e cura o atacante por uma porcentagem do dano causado*/
        if (habilidade.getNome().equals("Fúria do Guerreiro")) {
            alvo.receberDano(dano);
            int cura = (int) (dano * 0.2); // 20% de cura
            this.vida += cura;
        }

            /*Lança uma rajada venenosa que causa dano ao alvo ao longo de 3 turnos.*/
        else if (habilidade.getNome().equals("Rajada de Veneno")) {
            alvo.receberDano(dano);
            /*Personagem envenenado ao longo de 3 turnos*/
        }

    }


}

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private Personagem usuario;
    private ArrayList<Inimigo> inimigos;

    public Jogo() {
        this.inimigos = new ArrayList<>();
    }

    public Personagem getUsuario() {
        return usuario;
    }

    public void setUsuario(Personagem usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos() {
        inimigos.add(new Inimigo("Baraka", 75, 45, 15, 100, "Monstro"));
        inimigos.add(new Inimigo("Shang Tsung", 150, 60, 30, 200, "Comandante"));
        inimigos.add(new Inimigo("Shao Kahn", 250, 90, 45, 300, "Chefao"));
    }

    public void iniciarJogo() throws InterruptedException {
        setInimigos();
        System.out.println("Ola, aventureiro! Escolha o personagem que deseja jogar!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Guerreiro | 2 - Mago | 3 - Arqueiro");

        int escolhaPersonagem = scanner.nextInt();
        switch (escolhaPersonagem) {
            case 1:
                this.usuario = new Guerreiro("Guerreiro", 100, 20, 15, 20);
                break;
            case 2:
                this.usuario = new Mago("Mago", 80, 25, 35, 20);
                break;
            case 3:
                this.usuario = new Arqueiro("Arqueiro", 90, 20, 20, 10);
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente!");
                iniciarJogo();
        }

        Batalha batalha = new Batalha(this.getUsuario(), this.getInimigos());
        batalha.iniciarBatalha();

        System.out.println("FIM DE JOGO");
        this.desejaContinuar();
    }

    public void desejaContinuar() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja jogar novamente? (S/N)");
        String escolhaContinuar = scanner.next();
        if (escolhaContinuar.equalsIgnoreCase("S")) {
            iniciarJogo();
        } else {
            System.out.println("Obrigado por jogar!");
        }
    }
}

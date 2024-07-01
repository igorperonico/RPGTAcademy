import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main class for the game. It manages the game state, characters, and battles.
 */
public class Jogo {
    private Personagem usuario;
    private ArrayList<Inimigo> inimigos;

    /**
     * Constructor for the Jogo class. Initializes the list of enemies.
     */
    public Jogo() {
        this.inimigos = new ArrayList<>();
    }

    /**
     * This method is used to retrieve the user character object.
     *
     * @return Personagem The user character object.
     */
    public Personagem getUsuario() {
        return usuario;
    }

    public void setUsuario(Personagem usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }

    /**
     * This method is used to set up the initial list of enemies for the game.
     * It clears the existing list of enemies and adds new enemies to the list.
     *
     * @return void This method does not return any value.
     */
    public void setInimigos() {
        // Clear the existing list of enemies
        inimigos.clear();

        // Add new enemies to the list
        inimigos.add(new Inimigo("Baraka", 75, 45, 15, 100, "Monstro"));
        inimigos.add(new Inimigo("Shang Tsung", 150, 60, 30, 200, "Comandante"));
        inimigos.add(new Inimigo("Shao Kahn", 250, 90, 45, 300, "Chefao"));
    }

    /**
     * This method is used to start the game. It sets up the initial game state,
     * including choosing a character and initiating the first battle.
     *
     * @throws InterruptedException This method may throw InterruptedException if the thread is interrupted while waiting for input.
     */
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

    /**
     * This method is used to ask the player if they want to continue playing the game.
     * If the player chooses to continue, the game will start again.
     * If the player chooses not to continue, the game will end.
     *
     * @throws InterruptedException This method may throw InterruptedException if the thread is interrupted while waiting for input.
     */
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

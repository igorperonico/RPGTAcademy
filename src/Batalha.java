
import java.util.*;

/**
 * Represents a battle system between a player and multiple enemies.
 */
public class Batalha {

    private Personagem usuario;
    private ArrayList<Inimigo> inimigos;

    /**
     * Constructs a new battle instance.
     *
     * @param usuario  The player character in the battle.
     * @param inimigos The list of enemies in the battle.
     */
    public Batalha(Personagem usuario, ArrayList<Inimigo> inimigos) {
        this.usuario = usuario;
        this.inimigos = inimigos;
    }

    /**
     * Starts the battle between the player and enemies.
     *
     * @throws InterruptedException If the thread is interrupted during the battle.
     */
    public void iniciarBatalha() throws InterruptedException {
        while (usuario.isVivo() && !inimigos.isEmpty()) {

            Inimigo inimigo = inimigos.get(0);


            System.out.println("========================================================");
            System.out.println("                   INICIO DA GAMEPLAY  ");
            System.out.println("                       NIVEL " + usuario.getNivel());
            System.out.println("========================================================");
            while (usuario.isVivo() && inimigo.isVivo()) {
                this.imprimirAtributos();
                this.acaoUsuario();
                if (usuario.isFugir) break;

                this.imprimirAtributos();
                Thread.sleep(1000);

                if (inimigo.isDefendendo) inimigo.removerDefesa();
                if (inimigo.isVivo()) {
                    this.acaoInimigo();
                    if (usuario.isDefendendo) this.usuario.removerDefesa();
                } else {
                    System.out.println(inimigo.getNome() + " foi derrotado!");
                    System.out.println("========================================================");
                    usuario.adicionarXP(inimigo.getRecompensaXP());
                    inimigos.remove(0);
                }

            }
            if (usuario.isFugir) break;

        }
        if (usuario.isVivo() && !usuario.isFugir) {
            System.out.println("Você derrotou todos os inimigos!");
        } else {
            System.out.println("Você foi derrotado!");
        }
    }

    /**
     * This method handles the player's actions during the battle.
     * It prompts the player to choose an action (attack, use special skill, defend, or flee)
     * and performs the corresponding action.
     */
    public void acaoUsuario() {
        Inimigo inimigo = inimigos.get(0);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma ação a ser realizada:");
        System.out.println("1 - Atacar | 2 - Utilizar Habilidade Especial | 3 - Defender | 4 - Fugir");
        int acao = scanner.nextInt();

        switch (acao) {
            case 1:
                usuario.atacar(inimigo);
                System.out.println(usuario.getNome() + " atacou " + inimigo.getNome());

                break;
            case 2:
                System.out.println("Escolha uma habilidade especial:");
                System.out.println("1 - " + usuario.habilidades.get(0).getNome() + " | 2 - " + usuario.habilidades.get(1).getNome());
                int habilidadeEspecial = scanner.nextInt();
                if (habilidadeEspecial < 1 || habilidadeEspecial > 2) {
                    System.out.println("Habilidade invalida!");
                    break;
                }
                usuario.usarHabilidade(habilidadeEspecial - 1, inimigo);
                System.out.println(usuario.getNome() + " utilizou a habilidade " + usuario.habilidades.get(habilidadeEspecial - 1).getNome() + "!");

                break;
            case 3:
                usuario.defender();
                System.out.println(usuario.getNome() + " está em modo de defesa!");

                break;
            case 4:
                usuario.setFugir(true);
                System.out.println("Você fugiu do campo de batalha!");
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }

    /**
     * This method handles the enemy's actions during the battle.
     * It randomly selects an action (attack, use special skill, or defend)
     * and performs the corresponding action.
     */
    public void acaoInimigo() {
        Inimigo inimigo = inimigos.get(0);
        Random random = new Random();
        int acao = random.nextInt(3) + 1;

        switch (acao) {
            case 1:
                inimigo.atacar(usuario);
                System.out.println(inimigo.getNome() + " atacou " + usuario.getNome());
                break;
            case 2:
                int habilidadeEspecial = random.nextInt(2);
                inimigo.usarHabilidade(habilidadeEspecial, usuario);
                System.out.println(inimigo.getNome() + " utilizou a habilidade " + inimigo.habilidades.get(habilidadeEspecial).getNome() + "!");
                break;
            case 3:
                inimigo.defender();
                System.out.println(inimigo.getNome() + " está em modo de defesa!");
                break;
        }
    }

    /**
     * Prints the current attributes of the player and the first enemy in the battle.
     * This method is used to display the status of both characters during the battle.
     */
    public void imprimirAtributos() {
        Inimigo inimigo = inimigos.get(0);
        System.out.println("========================================================");
        System.out.println("Usuario: " + usuario.getNome() + " | Vida: " + usuario.getVida() + " | Forca: " + usuario.getForca() + " | Defesa: " + usuario.getDefesa());
        System.out.println("Inimigo: " + inimigo.getNome() + " | Vida: " + inimigo.getVida() + " | Forca: " + inimigo.getForca() + " | Defesa: " + inimigo.getDefesa());
        System.out.println("========================================================");
    }
}

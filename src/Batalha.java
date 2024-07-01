import java.sql.SQLOutput;
import java.util.*;

public class Batalha {

    private Personagem usuario;
    private ArrayList<Inimigo> inimigos;

    public Batalha(Personagem usuario, ArrayList<Inimigo> inimigos) {
        this.usuario = usuario;
        this.inimigos = inimigos;
    }

    /*Método para determinar a ordem dos turnos.*/
    /*public List<Personagem> ordemTurno(Personagem inimigo) {
        List<Personagem> personagens = new ArrayList<>();
        personagens.add(usuario);
        personagens.add(inimigo);

        *//*A ordem será escolhida de acordo com a força do personagem*//*
        Collections.sort(personagens, new Comparator<Personagem>() {
            @Override
            public int compare(Personagem p1, Personagem p2) {
                return Integer.compare(p2.getForca(), p1.getForca());
            }
        });

        return personagens;
    }*/

    public void iniciarBatalha() {
        while (usuario.isVivo() && !inimigos.isEmpty()) {

            Inimigo inimigo = inimigos.get(0);


            System.out.println("==============================");
            System.out.println("     INICIO DA GAMEPLAY  ");
            System.out.println("        NIVEL " + usuario.getNivel());
            System.out.println("==============================");
            while (usuario.isVivo() && inimigo.isVivo()) {
                this.imprimirAtributos();
                this.acaoUsuario();
                inimigo.removerDefesa();
                if (inimigo.isVivo()) {
                    this.acaoInimigo();
                    this.usuario.removerDefesa();
                } else System.out.println(inimigo.getNome() + " foi derrotado!");
            }
            inimigos.remove(0);
            System.out.println("==============================");
            usuario.adicionarXP(inimigo.getRecompensaXP());

        }
    }

    public void acaoUsuario() {
        Inimigo inimigo = inimigos.get(0);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma ação a ser realizada:");
        System.out.println("1 - Atacar | 2 - Utilizar Habilidade Especial | 3 - Defender");
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
            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }

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
                System.out.println(inimigo.getNome() + " utilizou a habilidade " + inimigo.habilidades.get(habilidadeEspecial - 1).getNome() + "!");
                break;
            case 3:
                inimigo.defender();
                System.out.println(inimigo.getNome() + " está em modo de defesa!");
                break;
        }
    }

    public void imprimirAtributos() {
        Inimigo inimigo = inimigos.get(0);
        System.out.println("==============================");
        System.out.println("Usuario: " + usuario.getNome() + " | Vida: " + usuario.getVida() + " | Defesa: " + usuario.getDefesa());
        System.out.println("Inimigo: " + inimigo.getNome() + " | Vida: " + inimigo.getVida() + " | Defesa: " + inimigo.getDefesa());
        System.out.println("==============================");
    }
}

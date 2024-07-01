//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     * @throws InterruptedException if any thread has interrupted the current thread
     */
    public static void main(String[] args) throws InterruptedException {

        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}
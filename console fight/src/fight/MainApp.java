package fight;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();

        Fighter fighterPlayer = new Fighter();
        Fighter fighterBot = new Fighter("BOT");

        game.greetings(fighterPlayer);
        game.gameLoop(fighterPlayer, fighterBot);
        game.waitClosing();

    }
}

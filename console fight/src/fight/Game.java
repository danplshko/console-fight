package fight;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    byte rounds;

    public void greetings(Fighter player) throws InterruptedException {
        System.out.println("Welcome to console fight game!");
        System.out.println("What's your name, warrior?: ");
        Scanner nameOfPlayer = new Scanner(System.in);
        player.name = nameOfPlayer.nextLine();
        System.out.println("How many rounds would you like to play?");
        Scanner roundsToPlay = new Scanner(System.in);
        rounds = roundsToPlay.nextByte();
        System.out.println("■■■■■■■■■■■■■■■■■■■■■");
    }
    public void gameLoop (Fighter player, Fighter bot) throws InterruptedException {
        for (int i = 1; i <= rounds; i++) {

            System.out.printf("The battle has started! Round %s%n", i);

            while (player.hp > 0 && bot.hp > 0) {

                int playerAttack = player.playerAttack();
                int playerDefense = player.playerDefense();

                int botAttack = bot.botAttack();
                int botDefense = bot.botDefense();

                sleepTime();

                if (playerAttack == botDefense) {
                    System.out.println("»»»»»» You missed!");
                } else {
                    System.out.println("»»»»»» You hit bot!");
                    bot.hp -= 2;
                }

                if (botAttack == playerDefense) {
                    System.out.println("»»»»»» You defended from attack!\n");
                } else {
                    System.out.println("»»»»»» Your defence didn't work!\n");
                    player.hp -= 2;
                }
                System.out.printf("""
                        »»»»»» You have hp:%s
                        »»»»»» Bot has  hp:%s%n""", player.hp, bot.hp);
            }

            if (player.hp > bot.hp) {
                System.out.println("""
                                ▓▓▓▓▓▓▓▓▓▓▓
                                ▓▓You won▓▓
                                ▓▓▓▓▓▓▓▓▓▓▓
                        """);
                player.resetHp();
                bot.resetHp();
            } else if (bot.hp > player.hp) {
                System.out.println("""
                                ▓▓▓▓▓▓▓▓▓▓▓▓
                                ▓▓You lose▓▓
                                ▓▓▓▓▓▓▓▓▓▓▓▓
                        """);
                player.resetHp();
                bot.resetHp();
            } else {
                System.out.println("""
                                ▓▓▓▓▓▓▓
                                ▓▓Tie▓▓
                                ▓▓▓▓▓▓▓
                        """);

                player.resetHp();
                bot.resetHp();
            }
        }
    }
    public void waitClosing(){
        System.out.print("Press Enter to exit.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public void sleepTime() throws InterruptedException {
        System.out.println();
        System.out.print("BOT is thinking");
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println();


    }
}
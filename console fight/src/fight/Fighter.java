package fight;

import java.util.Random;
import java.util.Scanner;

public class Fighter {
    String name;
    int hp = 6;

    public Fighter() {
    }

    public Fighter(String name) {
        this.name = name;
    }

    public int playerAttack(){
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Choose your ATTACK: ");
        System.out.println("[1]Head,[2]Body,[3]Legs");

        selection = input.nextInt();
        return selection;
    }
    public int playerDefense(){
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose your DEFENCE: ");
        System.out.println("[1]Head,[2]Body,[3]Legs");

        selection = input.nextInt();
        return selection;
    }

//    public int botAttack(){
//        Random randomBot = new Random();
//        int selection = randomBot.nextInt(3) +1;
//        return selection;
//    }
//    public int botDefense(){
//        Random randomBot = new Random();
//        int selection = randomBot.nextInt(3) +1;
//        return selection;
//    }

    public int botAttack(){
        Random randomBot = new Random();
        return randomBot.nextInt(3) +1;
    }
    public int botDefense(){
        Random randomBot = new Random();
        return randomBot.nextInt(3) +1;
    }

    public void resetHp(){
        this.hp = 6;
    }
}

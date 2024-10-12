import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class main {

    public static void generateAliens(int difficulty) {

        Random rng = new Random();
        int num =rng.nextInt(difficulty)+1;
//        if(num == 0){
//            for (int i = 0; i < aliens.length; i++) {
//
//                if (aliens[i]== null)
//                {
////                    System.out.println("a");
//                    num =  rng.nextInt(difficulty);
//                    Aliens alien = new Aliens(num,0);
//                    aliens[i] = alien;
//                    break;
//
//                }
//
//            }
//        }
        Aliens[] newAliens = new Aliens[aliens.length+num];
        for (int i = 0; i < aliens.length; i++) {
            if (aliens[i] != null) {
                newAliens[i] = aliens[i];
            }
        }
        for (int i = 0; i < num; i++) {
            int x = rng.nextInt(10);
            x = x*80+100;
            try {

                newAliens[aliens.length+i] = new Aliens(x,aliens[0].alienPosition.getY()+50);
            }
            catch (Exception e){}
        }
        aliens = newAliens;

    }

    public static void printScreen(String[][] screen){

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println("");
        }

    }
    public static boolean runGame(){
        for (int i = 0; i < aliens.length; i++) {
         if(aliens[i]!= null)
         {
             if (aliens[i].getAlienPosition().getY()==7)
                 return false;
         }
        }
        return true;
    }

    @Deprecated
    public static String[][] eraseScreen(){
        String[][] baseScreen= new String[9][11];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 11; j++) {
                baseScreen[i][j]="[]";
            }
        }
        for (int k = 0; k < 11; k++) {
            baseScreen[8][k] = "^^";
        }
//
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"},
//                {"^^", "^^", "^^", "^^", "^^", "^^", "^^", "^^", "^^", "^^", "^^"}
//        };
        return baseScreen;
    }

    @Deprecated
    public static void printGame(String[][] screen,Ship ship,Aliens[] Aliens){

        screen[ship.getShipPosition().getY()][ship.getShipPosition().getX()]= "><";

        for (int i = 0; i < Aliens.length; i++) {
            if (aliens[i]!= null)
                screen[aliens[i].getAlienPosition().getY()][aliens[i].getAlienPosition().getX()]= "pq";

        }

        for (int i = 0; i < ship.getBullets().length; i++) {
            if (ship.getBullets()[i]!=null){
                screen[ship.getBullets()[i].getY()][ship.getBullets()[i].getX()] = "!!";

            }

        }

        printScreen(screen);



    }
    public static void generateRecs(){
        Rectengles[] recs =new Rectengles[aliens.length+1];
        recs[0] = ship.getRectengle();
        for (int i = 0; i < aliens.length; i++) {
            if(aliens[i]!=null)
                recs[i+1]=aliens[i].getRectengle();
        }
        rectengles = recs;
    }

    public static void moveAliens(){
        for (int i = 0; i < aliens.length; i++) {
            if(aliens[i]!=null) {
                aliens[i].move();

            }
        }
    }

    public static boolean allMyFriendsAreDead(){
        for (int i = 0; i < aliens.length; i++) {
            if (aliens[i]!=null)
                return false;
        }
        return true;
    }
    public static boolean isDead(){

        for (int i = 0; i < aliens.length; i++) {
            if (aliens[i]!=null)
            if (aliens[i].getAlienPosition().getY()+aliens[i].getAlienPosition().getWidth()/2>=ship.getShipPosition().getY())
                return true;

        }
        return false;
    }

    public static String [][] screen = eraseScreen();
    public static Ship ship = new Ship(475, 600);
    public static Aliens[] aliens = new Aliens[1];
    public static Rectengles[] rectengles = new Rectengles[10];

    public static void main(String[] args) throws  InterruptedException {
//        KeyEvent keys = new KeyEvent()


        AlienBoss boss = new AlienBoss(450,50,50);
        boss.setMovmentMultiplier(1);
        aliens[0] = boss;

        Window win = new Window(1000,650);

        win.setFocusable(true);
        win.addKeyListener(new KeyListner(ship));






        int a = 3;
        int delay = 100;
        int delay1 = 10;
        boolean endGame = false;
        Random rng = new Random( );
        while (runGame()) {

            generateRecs();
            win.repaint();
            ship.readyShip(aliens);

            Thread.sleep(delay);


            moveAliens();
            if(aliens[0]== null&& !allMyFriendsAreDead()&&!endGame){
                endGame = true;
                aliens =new Aliens[1];
                ship.setBullets(new Position[0]);
                aliens[0] = new AlienBoss(500,100,75,75,20);
                aliens[0].setMovmentMultiplier(10);}

            else if(aliens[0]!= null&&!endGame)
            {
                if (delay1 == 1){
                    generateAliens(8);
                    a =rng.nextInt(4);
                    delay1 = (25+a);
                }
                delay1--;
            }
            else if(aliens[0]!= null){
                aliens[0].setCanShoot(true);
            }
            else
            {

                System.out.println("you win!!!");
                break;
            }
            if(isDead()){
                System.out.println("you Lose, try again!!!");
                break;
            }
            aliens[0].readyAlien();

            for (int i = 0; i < aliens.length; i++) {

                if (aliens[i]!=null){
                    if (aliens[i].isCanShoot())


                        aliens[i].shoot();

                }

            }






        }
    }
}


package org.academiadecodigo.haltistas.chronometer;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Game g = new Game();

        //g.start();
        //g.chronometer();

       Grid grid = new Grid();
       Background background = new Background();
       Timer timer = new Timer();
       DrawCharacter characterDraw = new DrawCharacter();


        while(true) {

            grid.drawGrid();

            Thread.sleep(70);
            background.drawBackground();

            Thread.sleep(70);
            characterDraw.drawPlayerOneAlive("assets/player1Alive.png");
            characterDraw.drawPLayerTwoAlive("assets/player2Alive.png");


            timer.startCountdown();

            characterDraw.deletePlayer(characterDraw.getPlayerOne());
            characterDraw.deletePlayer(characterDraw.getPlayerTwo());

            characterDraw.drawPlayerOneDead("assets/player1Dead.png");
            characterDraw.drawPlayerTwoDead("assets/player2Dead.png");

            Thread.sleep(1000);

            characterDraw.deletePlayer(characterDraw.getPlayerOne());
            characterDraw.deletePlayer(characterDraw.getPlayerTwo());



        }

    }
}



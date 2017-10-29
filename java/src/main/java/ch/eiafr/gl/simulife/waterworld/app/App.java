package ch.eiafr.gl.simulife.waterworld.app;

import ch.eiafr.gl.simulife.waterworld.world.MyWorld;
import ch.eiafr.gl.simulife.waterworld.creature.HammerheadShark;
import ch.eiafr.gl.simulife.waterworld.creature.Ice;
import ch.eiafr.gl.simulife.waterworld.creature.Orca;
import ch.eiafr.gl.simulife.waterworld.creature.Penguin;
import ch.eiafr.gl.simulife.waterworld.creature.WhiteShark;

import java.util.Random;

import ch.eiafr.gl.simulife.gui.UserInterface;
import ch.eiafr.gl.simulife.gui.game.GameGraphicView;
import ch.eiafr.gl.simulife.gui.game.GameMatrixView;
import ch.eiafr.gl.simulife.gui.game.GameTextView;

public class App {

    public static void main(String[] args) {

        MyWorld myWorld = new MyWorld(6, 6);

        UserInterface userGraphiqueInterface = new UserInterface(new GameGraphicView(myWorld.getNbCols(), myWorld.getNbRows()));
        myWorld.addObserver(userGraphiqueInterface);

        UserInterface userGameMatrixView = new UserInterface(new GameMatrixView(myWorld.getNbCols(), myWorld.getNbRows()));
        myWorld.addObserver(userGameMatrixView);

        UserInterface userTextInterface = new UserInterface(new GameTextView());
        myWorld.addObserver(userTextInterface);

        Orca orca = new Orca();
        WhiteShark[] whiteSharks = new WhiteShark[5];
        for (int i = 0; i < whiteSharks.length; i++)
            whiteSharks[i] = new WhiteShark();
        HammerheadShark[] hammerheadSharks = new HammerheadShark[5];
        for (int i = 0; i < hammerheadSharks.length; i++)
            hammerheadSharks[i] = new HammerheadShark();
        Penguin[] penguins = new Penguin[5];
        for (int i = 0; i < penguins.length; i++)
            penguins[i] = new Penguin();
        Ice[] ice = new Ice[10];
        for (int i = 0; i < ice.length; i++)
            ice[i] = new Ice();
        boolean game_not_finished = true;
        int loop_id = 0;
        Random random = new Random();
        init();
        while (game_not_finished) {

            int[] moveOrca = myWorld.calcMove(orca);
            myWorld.moveCreature(orca, moveOrca[0], moveOrca[1]);
            myWorld.updateView();
            waitUpdate();
            for (int i = 0; i < whiteSharks.length; i++) {
                int[] move_whiteShark = myWorld.calcMove(whiteSharks[i]);
                myWorld.moveCreature(whiteSharks[i], move_whiteShark[0], move_whiteShark[1]);

            }
            myWorld.updateView();
            waitUpdate();
            for (int i = 0; i < hammerheadSharks.length; i++) {
                int[] move_hammerheadShark = myWorld.calcMove(hammerheadSharks[i]);
                myWorld.moveCreature(hammerheadSharks[i], move_hammerheadShark[0], move_hammerheadShark[1]);

            }
            myWorld.updateView();
            waitUpdate();
            if (loop_id++ % 2 == 0) {
                for (int i = 0; i < penguins.length; i++) {
                    int[] move_penguin = myWorld.calcMove(penguins[i]);
                    myWorld.moveCreature(penguins[i], move_penguin[0], move_penguin[1]);

                }
                myWorld.updateView();
                waitUpdate();
            }
            for (int i = 0; i < ice.length; i++) {
                int[] move_ice = new int[2];
                if (random.nextBoolean()) {
                    move_ice = myWorld.addIce(ice[i]);
                } else {
                    move_ice = myWorld.removeIce(ice[i]);
                }
                myWorld.moveCreature(ice[i], move_ice[0], move_ice[1]);
                myWorld.updateView();
                waitUpdate();

            }

        }

    }

    private static void waitUpdate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void init() {

    }
}
